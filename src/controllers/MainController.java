package controllers;
import utils.Utils;
import views.MainView;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Rico on 6/17/15.
 */
public class MainController {

    private static MainController mc;

    public static MainController getInstance() {
        return mc == null ? new MainController() : mc;
    }

    private ClaimController cc;
    private WelcomeController wc;
    private RegisterController rc;
    private InfoController ic;

    private MainController() {
        wc = new WelcomeController();
        cc = new ClaimController();
    }

    private static void init() {
        Path path = Paths.get(Utils.CONFIG_PROPS.getProperty("data-store-path"));
        if (!Files.exists(path)) try {
            Files.createDirectories(path);
        } catch (IOException e) {
            System.out.println("fail to create data store directory");
        }
        MainView.getInstance().setVisible(true);
    }


    public static void main(String[] args) {
        init();

    }

    public ClaimController getClaimController() {
        return cc;
    }

    public WelcomeController getWelcomeController() {
        return wc;
    }

    public RegisterController getRegisterController() {
        return rc;
    }

    public InfoController getInfoController() {
        return ic;
    }

}
