package controllers.impl;

import controllers.interfaces.WelcomeController;
import dao.impl.file.UserImpl;
import dao.interfaces.UserDao;
import dao.model.User;

/**
 * Created by Rico on 6/17/15.
 */
public class WelcomeImpl implements WelcomeController {

    UserDao ud = new UserImpl();
    @Override
    public boolean validate(String userName, String password) {
        User u = ud.getUserByUserName(userName);
        return u.getPassword().equals(password);
    }
}
