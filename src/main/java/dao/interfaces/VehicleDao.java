package dao.interfaces;

import dao.model.Vehicle;

import java.util.List;

/**
 * Created by Rico on 6/13/15.
 */
public interface VehicleDao {
    boolean addVehicle(Vehicle u);
    boolean updateVehicle(Vehicle u);
    boolean deleteVehicle(Vehicle u);
    Vehicle getVehicleByVehicleId(long id);
    List<Vehicle> getVehiclesByUserId(long uid);
}
