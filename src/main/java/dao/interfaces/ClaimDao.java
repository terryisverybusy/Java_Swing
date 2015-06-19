package dao.interfaces;

import dao.model.Claim;

import java.util.List;

public interface ClaimDao {
    boolean addClaim(Claim c);
    boolean updateClaim(Claim c);
    boolean deleteClaim(Claim c);
    List<Claim> getClaimByTitle(String t);
    List<Claim> getClaimByUserId(long uid);
    Claim getClaimByClaimId(long cid);
}