package controllers;

import dao.impl.file.ClaimImpl;
import dao.interfaces.ClaimDao;
import dao.model.Claim;

/**
 * Created by Rico on 6/18/15.
 */
public class ClaimController {
    ClaimDao cd = new ClaimImpl();
    public boolean addClaim(long uid, String title, String content){
        Claim c = new Claim(uid,title,content);
        return cd.addClaim(c);
    }
}
