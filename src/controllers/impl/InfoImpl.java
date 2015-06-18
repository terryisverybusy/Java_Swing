package controllers.impl;

import controllers.interfaces.InfoController;
import dao.impl.file.PolicyImpl;
import dao.interfaces.PolicyDao;
import dao.model.Policy;
import dao.model.User;

import java.util.List;

/**
 * Created by Rico on 6/17/15.
 */
public class InfoImpl implements InfoController {
    PolicyDao pd = new PolicyImpl();
    @Override
    public List<Policy> getPolicies(User u) {
        return pd.getPolicyByUserId(u.getId());
    }
}
