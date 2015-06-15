package dao.impl.file;

import dao.interfaces.ClaimDao;
import dao.model.Claim;
import utils.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class ClaimImpl implements ClaimDao {
    private final String FILENAME = "claim.txt";
    private Path claimFile;

    public ClaimImpl() {
        claimFile = Paths.get(Utils.CONFIG_PROPS.getProperty("data-store-path"), FILENAME);
        try {
            if (!Files.exists(claimFile)) Files.createFile(claimFile);
        } catch (IOException e) {
            System.out.println("fail to create " + FILENAME);
        }
    }

    @Override
    public boolean addClaim(Claim u) {
        return FileOperations.saveRecordToFile(claimFile, u.toString());
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
