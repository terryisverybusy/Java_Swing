package controllers;

import dao.impl.file.PolicyImpl;
import dao.impl.file.VehicleImpl;
import dao.interfaces.PolicyDao;
import dao.interfaces.VehicleDao;
import dao.model.Policy;
import dao.model.User;
import dao.model.Vehicle;

import java.util.List;

/**
 * Created by Rico on 6/17/15.
 */
public class InfoController {

    PolicyDao pd = new PolicyImpl();
    VehicleDao vd = new VehicleImpl();

    public List<Vehicle> getVehicles(User user){
        return vd.getVehiclesByUserId(user.getId());
    }

    public Policy getPolicy(User u, Vehicle v) {
        return pd.getPolicyByUserId(u.getId()).stream().filter(p -> p.getVehicleId() == v.getId()).findFirst().get();
    }
}
