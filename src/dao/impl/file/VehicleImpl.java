package dao.impl.file;

import dao.interfaces.VehicleDao;
import dao.model.Vehicle;
import utils.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VehicleImpl implements VehicleDao {
    private final String FILENAME = "vehicle.txt";
    Path vehicleFile;

    public VehicleImpl(){
        vehicleFile = Paths.get(Utils.CONFIG_PROPS.getProperty("data-store-path"), FILENAME);
        try {
            if (!Files.exists(vehicleFile)) Files.createFile(vehicleFile);
        } catch (IOException e) {
            System.out.println("fail to create " + FILENAME);
        }
    }

    @Override
    public boolean addVehicle(Vehicle v) {
        return FileOperations.saveRecordToFile(vehicleFile,v.toString());
    }

    @Override
    public boolean updateVehicle(Vehicle v) {
        return deleteVehicle(v) & addVehicle(v);
    }

    @Override
    public boolean deleteVehicle(Vehicle v) {
        String vid = "v"+v.getId();
        return FileOperations.deleteRecordFromFile(vehicleFile,vid);
    }

    @Override
    public Vehicle getVehicleByVehicleId(long id) {
        String vid = "v"+id;
        String s = FileOperations.loadRecordsFromFile(vehicleFile,vid).get(0);
        return new Vehicle(s);
    }

    @Override
    public List<Vehicle> getVehiclesByUserId(long uid) {
        List<Vehicle> lv = new ArrayList<>();
        String str = "u"+uid;
        FileOperations.loadRecordsFromFile(vehicleFile,str).forEach(v->lv.add(new Vehicle(v)));
        return lv;
    }
}
