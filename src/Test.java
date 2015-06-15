import dao.impl.file.ClaimImpl;
import dao.interfaces.ClaimDao;
import dao.model.Claim;
import utils.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

/**
 * Created by Rico on 6/14/15.
 */
public class Test {

    public static void main(String[] args) {

        Path dataDir = Paths.get(Utils.CONFIG_PROPS.getProperty("data-store-path"));
        if (!Files.exists(dataDir))
            try {
                Files.createDirectories(dataDir);
            } catch (IOException e) {
                e.printStackTrace();
            }

        ClaimDao cd = new ClaimImpl();
        Claim c = new Claim(2, 001, "collision", LocalDateTime.now(), "I run into a car on the corner");
        for(Claim claim:cd.searchClaimByClaimTitle("collision"))
            System.out.println(claim);
    }
}
