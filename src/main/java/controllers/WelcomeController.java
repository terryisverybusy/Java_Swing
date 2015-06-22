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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Rico on 6/18/15.
 */
public class WelcomeController {
    UserDao ud = new UserImpl();
    VehicleDao vd = new VehicleImpl();
    PolicyDao pd = new PolicyImpl();

    public boolean validate(String userName, String password) {
        boolean result = false;
        User u = ud.getUserByUserName(userName);
        if (u==null || userName.equals("")) return result;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            u.getPassword().getBytes().equals(md.digest(password.getBytes()));
            result = true;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
    public User getUser(String userName){
        return ud.getUserByUserName(userName);
    }
    public List<Vehicle> getVehicles(Long uid){
        return vd.getVehiclesByUserId(uid);
    }
    public List<Policy> getPolicies(long uid){
        return pd.getPolicyByUserId(uid);
    }

}
