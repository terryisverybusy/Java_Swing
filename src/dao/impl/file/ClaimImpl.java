package dao.impl.file;

import dao.interfaces.ClaimDao;
import dao.model.Claim;
import utils.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        return deleteClaim(u) & addClaim(u);
    }

    @Override
    public boolean deleteClaim(Claim c) {
        String cid = "c" + String.valueOf(c.getId());
        return FileOperations.deleteRecordFromFile(claimFile, cid);
    }

    @Override
    public List<Claim> getClaimByTitle(String title) {
        List<Claim> lc = new ArrayList<>();
        FileOperations.loadRecordsFromFile(claimFile, title).forEach(s -> lc.add(new Claim(s)));
        return lc;
    }

    @Override
    public List<Claim> getClaimByUserId(long uid) {
        List<Claim> lc = new ArrayList<>();
        String str = "u"+String.valueOf(uid);
        FileOperations.loadRecordsFromFile(claimFile,str).forEach(s -> lc.add(new Claim(s)));
        return lc;
    }

    @Override
    public Claim getClaimByClaimId(long cid) {
        String str = "c"+String.valueOf(cid);
        Claim c = new Claim(FileOperations.loadRecordsFromFile(claimFile,str).get(0));
        return c;
    }


}
