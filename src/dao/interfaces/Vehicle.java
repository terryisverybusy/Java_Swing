package dao.interfaces;

/**
 * Created by Rico on 6/13/15.
 */
public interface Vehicle {
    boolean addVehicle(Vehicle u);
    boolean updateVehicle(Vehicle u);
    boolean deleteVehicle(Vehicle u);
    Vehicle getVehicleByVehicleId(int id);
}
