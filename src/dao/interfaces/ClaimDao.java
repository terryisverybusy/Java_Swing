package dao.interfaces;

import dao.model.Claim;

import java.util.List;

/**
 * Created by Rico on 6/13/15.
 */
public interface ClaimDao {
    boolean addClaim(Claim u);
    boolean updateClaim(Claim u);
    boolean deleteClaim(Claim u);
    List<Claim> searchClaimByClaimTitle(String title);
    Claim getClaimByClaimId(int id);
}
