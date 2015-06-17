package controllers.impl;

import controllers.interfaces.RegisterController;
import dao.model.Policy;
import dao.model.User;
import dao.model.Vehicle;

/**
 * Created by Rico on 6/17/15.
 */
public class RegisterImpl implements RegisterController{

    @Override
    public boolean addUser(User u) {
        return false;
    }

    @Override
    public boolean addVehicle(Vehicle v) {
        return false;
    }

    @Override
    public boolean addPolicy(Policy p) {
        return false;
    }
}
