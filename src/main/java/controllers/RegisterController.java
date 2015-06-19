package controllers;

import dao.impl.file.PolicyImpl;
import dao.impl.file.UserImpl;
import dao.impl.file.VehicleImpl;
import dao.interfaces.PolicyDao;
import dao.interfaces.UserDao;
import dao.interfaces.VehicleDao;
import dao.model.Policy;
import dao.model.User;
import dao.model.Vehicle;
import views.MainView;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

/**
 * Created by Rico on 6/17/15.
 */
public class RegisterController {

    MainView mainView = MainView.getInstance();
    UserDao ud = new UserImpl();
    VehicleDao vd = new VehicleImpl();
    PolicyDao pd = new PolicyImpl();


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


    public Vehicle addVehicle(long uid, String brand, int year, String model, int miles, double basePrice) {
        Vehicle v = new Vehicle(uid, brand, year, model, miles, basePrice);
        vd.addVehicle(v);
        return v;
    }


    public Policy addPolicy(long vehicleId, long userId, double price, Policy.Type type, Policy.Duration duration, Policy.Usage usage) {
        Policy p = new Policy(vehicleId, userId, price, type, duration, usage);
        pd.addPolicy(p);
        return p;
    }

    private boolean validateUserInfo(String userName, LocalDate birthday, String email, String occupation) {
        return userName.matches("[\\d\\w]+") &&
                birthday.isBefore(LocalDate.now().minusYears(18)) &&
                email.matches("[\\d\\w.]+[@][\\d\\w]+[.][\\w]+") &&
                occupation.matches("[\\w]+");
    }

}
