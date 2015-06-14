package dao.impl.file;

import dao.interfaces.ClaimDao;
import dao.model.Claim;
import utils.Utils;

import javax.rmi.CORBA.Util;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Rico on 6/13/15.
 */
public class ClaimImpl implements ClaimDao{
    private final String FILENAME = "claim.txt";
    private Path claimFile;

    ClaimImpl(){
        claimFile = Paths.get(Utils.CONFIG_PROPS.getProperty("data-store-path"),FILENAME);
    }

    @Override
    public boolean addClaim(Claim u) {
        return FileOperations.saveRecordToFile(claimFile,u.toString());
    }

    @Override
    public boolean updateClaim(Claim u) {
        return false;
    }

    @Override
    public boolean deleteClaim(Claim u) {
        return false;
    }

    @Override
    public List<Claim> searchClaimByClaimTitle(String title) {
        return null;
    }

    @Override
    public Claim getClaimByClaimId(int id) {
        return null;
    }

}
