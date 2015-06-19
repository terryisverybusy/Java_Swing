package controllers;

import dao.impl.file.UserImpl;
import dao.interfaces.UserDao;
import dao.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Rico on 6/18/15.
 */
public class WelcomeController {
    UserDao ud = new UserImpl();

    public boolean validate(String userName, String password) {
        boolean result = false;
        User u = ud.getUserByUserName(userName);
        if (u==null) return result;
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

}
