package controllers;

import dao.impl.file.UserImpl;
import dao.interfaces.UserDao;
import dao.model.User;

/**
 * Created by Rico on 6/18/15.
 */
public class WelcomeController {
    UserDao ud = new UserImpl();

    public boolean validate(String userName, String password) {
        User u = ud.getUserByUserName(userName);
        return u.getPassword().equals(password);
    }
}
