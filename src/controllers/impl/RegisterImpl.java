package controllers.impl;

import controllers.interfaces.RegisterController;
import dao.impl.file.PolicyImpl;
import dao.impl.file.UserImpl;
import dao.impl.file.VehicleImpl;
import dao.interfaces.PolicyDao;
import dao.interfaces.UserDao;
import dao.interfaces.VehicleDao;
import dao.model.Policy;
import dao.model.User;
import dao.model.Vehicle;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

/**
 * Created by Rico on 6/17/15.
 */
public class RegisterImpl implements RegisterController {
    UserDao ud = new UserImpl();
    VehicleDao vd = new VehicleImpl();
    PolicyDao pd = new PolicyImpl();


    @Override
    public boolean addUser(String userName, String password, String email, String firstName, String lastName, String birthday, String occupation, String address, String licenseDate) {
        LocalDate birth = LocalDate.parse(birthday);
        if (!validateUserInfo(userName, birth, email, occupation)) return false;
        else {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                String pwd = new String(md.digest(password.getBytes()), Charset.defaultCharset());
                User u = new User(userName,pwd,email,firstName,lastName,birth,occupation,address,LocalDate.parse(licenseDate));
                ud.addUser(u);
            } catch (NoSuchAlgorithmException e) {e.printStackTrace();}


        }


    }

    @Override
    public boolean addVehicle(Vehicle v) {
        return vd.addVehicle(v);
    }

    @Override
    public boolean addPolicy(Policy p) {
        return pd.addPolicy(p);
    }

    private boolean validateUserInfo(String userName, LocalDate birthday, String email, String occupation) {
        return userName.matches("[\\d\\w]+") &&
                birthday.isBefore(LocalDate.now().minusYears(18)) &&
                email.matches("[\\d\\w.]+[@][\\d\\w]+[.][\\w]+") &&
                occupation.matches("[\\w]+");
    }

}
