package dao.impl.file;

import dao.interfaces.PolicyDao;
import dao.model.Policy;
import utils.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rico on 6/15/15.
 */
public class PolicyImpl implements PolicyDao {
    private final String FILENAME = "policy.txt";
    private Path policyFile;

    public PolicyImpl() {
        policyFile = Paths.get(Utils.CONFIG_PROPS.getProperty("data-store-path"), FILENAME);
        try {
            if (!Files.exists(policyFile)) Files.createFile(policyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addPolicy(Policy p) {
        return FileOperations.saveRecordToFile(policyFile, p.toString());
    }

    @Override
    public boolean updatePolicy(Policy p) {
        return deletePolicy(p) & addPolicy(p);
    }

    @Override
    public boolean deletePolicy(Policy p) {
        String pid = "p" + String.valueOf(p.getId());
        return FileOperations.deleteRecordFromFile(policyFile, pid);
    }

    @Override
    public Policy getPolicyByPolicyId(long id) {
        String pid = "p" + id;
        String s = FileOperations.loadRecordsFromFile(policyFile,pid).get(0);
        return new Policy(s);
    }

    @Override
    public List<Policy> getPolicyByUserId(long id) {
        String uid = "u"+id;
        List<Policy> lp = new ArrayList<>();
        FileOperations.loadRecordsFromFile(policyFile,uid).forEach(p -> lp.add(new Policy(p)));
        return lp;
    }

    @Override
    public List<Policy> getPolicyByVehicleId(long id) {
        String vid = "v"+id;
        List<Policy> lp = new ArrayList<>();
        FileOperations.loadRecordsFromFile(policyFile,vid).forEach(p -> lp.add(new Policy(p)));
        return lp;
    }

}
