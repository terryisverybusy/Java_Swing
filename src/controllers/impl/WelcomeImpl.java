package controllers.impl;

import controllers.interfaces.WelcomeController;

/**
 * Created by Rico on 6/17/15.
 */
public class WelcomeImpl implements WelcomeController {

    @Override
    public boolean validate(String userName, String password) {
        return false;
    }
}
