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

    private static ClaimController cc;
    private static WelcomeController wc;
    private static RegisterController rc;
    private static InfoController ic;
    private static MainView mv;


    private void init() {
        Path path = Paths.get(Utils.CONFIG_PROPS.getProperty("data-store-path"));
        if (!Files.exists(path)) try {
            Files.createDirectory(path);
        } catch (IOException e) {
            System.out.println("fail to create data store directory");
        }
        mv = new MainView();
        mv.setVisible(true);
        wc = new WelcomeController();
        cc = new ClaimController();
        rc = new RegisterController();
        ic = new InfoController();
    }


    public static void main(String[] args) {

        MainController.getInstance().init();

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
