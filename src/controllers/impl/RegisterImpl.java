package controllers.impl;

import controllers.interfaces.RegisterController;
import dao.impl.file.UserImpl;
import dao.interfaces.UserDao;
import dao.model.Policy;
import dao.model.User;
import dao.model.Vehicle;

import java.time.LocalDate;

/**
 * Created by Rico on 6/17/15.
 */
public class RegisterImpl implements RegisterController {
    UserDao ud = new UserImpl();

    @Override
    public boolean addUser(User u) {
        if (!validateUserInfo(u)) return false;
        else return ud.addUser(u);
    }

    @Override
    public boolean addVehicle(Vehicle v) {
        return false;
    }

    @Override
    public boolean addPolicy(Policy p) {
        return false;
    }

    private boolean validateUserInfo(User u) {
        return u.getUserName().matches("[\\d\\w]+") &&
                u.getBirthday().isBefore(LocalDate.now().minusYears(18)) &&
                u.getEmail().matches("[\\d\\w.]+[@][\\d\\w]+[.][\\w]+")&&
                u.getOccupation().matches("[\\w]+");
    }
}
