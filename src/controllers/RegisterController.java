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
import java.util.List;

/**
 * Created by Rico on 6/17/15.
 */
public class RegisterController {

    MainView mainView = MainView.getInstance();
    UserDao ud = new UserImpl();
    VehicleDao vd = new VehicleImpl();
    PolicyDao pd = new PolicyImpl();
    User user;
    private List<Vehicle> vehicles;
    private List<Policy>  policies;




    public boolean addUser(String userName, String password, String email, String firstName, String lastName, String birthday, String occupation, String address, String licenseDate) {
        boolean result = false;
        LocalDate birth = LocalDate.parse(birthday);
        if (!validateUserInfo(userName, birth, email, occupation)) return result;
        else {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                String pwd = new String(md.digest(password.getBytes()), Charset.defaultCharset());
                user = new User(userName,pwd,email,firstName,lastName,birth,occupation,address,LocalDate.parse(licenseDate));
                ud.addUser(user);
                result = true;
            } catch (NoSuchAlgorithmException e) {e.printStackTrace();}
        }
        return result;
    }


    public boolean addVehicle(String brand, int year, String model, int miles, double basePrice ) {
        return false;
    }


    public boolean addPolicy(long vehicleId, long userId, double price, Policy.Type type, Policy.Duration duration, Policy.Usage usage) {
        return false;
    }

    private boolean validateUserInfo(String userName, LocalDate birthday, String email, String occupation) {
        return userName.matches("[\\d\\w]+") &&
                birthday.isBefore(LocalDate.now().minusYears(18)) &&
                email.matches("[\\d\\w.]+[@][\\d\\w]+[.][\\w]+") &&
                occupation.matches("[\\w]+");
    }

}
