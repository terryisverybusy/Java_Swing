package controllers;

import dao.impl.file.ClaimImpl;
import dao.impl.file.PolicyImpl;
import dao.impl.file.UserImpl;
import dao.impl.file.VehicleImpl;
import dao.interfaces.ClaimDao;
import dao.interfaces.PolicyDao;
import dao.interfaces.UserDao;
import dao.interfaces.VehicleDao;
import dao.model.Claim;
import dao.model.Policy;
import dao.model.User;
import dao.model.Vehicle;
import utils.Utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

/**
 * Created by Rico on 6/17/15.
 */
public class RegisterController {

    //    MainView mainView = MainView.getInstance();
    UserDao ud = new UserImpl();
    VehicleDao vd = new VehicleImpl();
    PolicyDao pd = new PolicyImpl();
    ClaimDao cd = new ClaimImpl();


    public User addUser(String userName, String password, String email, String firstName, String lastName, String birthday, String occupation, String address, String licenseDate) {
        User u = null;
        if (!(ud.getUserByUserName(userName) == null)) return u;
        LocalDate birth = LocalDate.parse(birthday);
        if (!validateUserInfo(userName, birth, email, occupation)) return u;
        else {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                String pwd = new String(md.digest(password.getBytes()), Charset.defaultCharset());
                u = new User(userName, pwd, email, firstName, lastName, birth, occupation, address, LocalDate.parse(licenseDate));
                ud.addUser(u);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return u;
    }


    public Vehicle addVehicle(long uid, String brand, String year, String model, String miles, String basePrice) {
        if (!validateVehicleInfo(year, miles, basePrice)) return null;
        Vehicle v = new Vehicle(uid, brand, Integer.parseInt(year), model, Integer.parseInt(miles), Double.parseDouble(basePrice));
        vd.addVehicle(v);
        return v;
    }


    public Policy addPolicy(Vehicle v, User u, String type, String duration, String usage) {

        Policy.Type tp = Policy.Type.valueOf(type);
        Policy.Duration dt = Policy.Duration.valueOf(duration);
        Policy.Usage ug = Policy.Usage.valueOf(usage);

        double price = calculatePrice(v, u, tp, dt, ug);

        Policy p = new Policy(v.getId(), u.getId(), price, tp, dt, ug);
        pd.addPolicy(p);
        return p;
    }

    private boolean validateUserInfo(String userName, LocalDate birthday, String email, String occupation) {
        return userName.matches("[\\d\\w]+") &&
                birthday.isBefore(LocalDate.now().minusYears(18)) &&
                email.matches("[\\d\\w.]+[@][\\d\\w]+[.][\\w]+") &&
                occupation.matches("[\\w]+");
    }

    private boolean validateVehicleInfo(String year, String miles, String basePrice) {
        return
                year.matches("[\\d]{4}") &&
                miles.matches("[\\d]+") &&
                basePrice.matches("[\\d.]+")&&
                Integer.parseInt(year)<= LocalDate.now().getYear();
    }

    private double calculatePrice(Vehicle v, User u, Policy.Type type, Policy.Duration duration, Policy.Usage usage) {
        double result = v.getBasePrice();
        int thisYear = LocalDate.now().getYear();

        Properties props = Utils.CONFIG_PROPS;
        double pOccupation = Double.parseDouble(props.getProperty("punish-u-occupation"));
        double pLicense = Double.parseDouble(props.getProperty("punish-u-license"));
        double pYear = Double.parseDouble(props.getProperty("punish-v-year"));
        double pMiles = Double.parseDouble(props.getProperty("punish-v-miles"));
        int pCI = Integer.parseInt(props.getProperty("punish-p-CI"));
        int pTPO = Integer.parseInt(props.getProperty("punish-p-TPO"));
        int pTPTF = Integer.parseInt(props.getProperty("punish-p-TPTF"));
        double pHALF = Double.parseDouble(props.getProperty("punish-p-HALF"));
        double pONE = Double.parseDouble(props.getProperty("punish-p-ONE"));
        int pLOW = Integer.parseInt(props.getProperty("punish-p-low"));
        int pMID = Integer.parseInt(props.getProperty("punish-p-mid"));
        int pHIGH = Integer.parseInt(props.getProperty("punish-p-high"));
        double pClaim = Double.parseDouble(props.getProperty("punish-c-claim"));

        result *= pLicense / (thisYear - u.getLicenseDate().getYear()+1);
        if (u.getOccupation().equals("") || u.getOccupation().equals("student") || u.getOccupation() == null)
            result *= pOccupation;

        result *= pYear / (thisYear - v.getYear()+1);

        result *= v.getMiles() / pMiles;

        switch (type) {
            case CI:
                result *= pCI;
                break;
            case TPO:
                result *= pTPO;
                break;
            case TPFT:
                result *= pTPTF;
                break;
        }

        result *= (duration == Policy.Duration.HALF) ? pHALF : pONE;

        switch (usage) {
            case LOW:
                result *= pLOW;
                break;
            case MID:
                result *= pMID;
                break;
            case HEAVY:
                result *= pHIGH;
                break;
        }
        int last = 5;
        List<Claim> lc = cd.getClaimByUserId(u.getId());
        if (lc.size() > 0) {
            Claim claim = lc.stream().max((c1, c2) -> c1.getCreateTime().compareTo(c2.getCreateTime())).get();
            last = thisYear -claim.getCreateTime().getYear() > 5 ? 5 : thisYear - claim.getCreateTime().getYear();
        }

        result *= pClaim / (last+1);


        return result;

    }
}
