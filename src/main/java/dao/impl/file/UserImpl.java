package dao.impl.file;

import dao.interfaces.UserDao;
import dao.model.User;
import utils.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UserImpl implements UserDao{
    private final String FILENAME  = "user.txt";
    Path userFile;

    public UserImpl(){
        userFile = Paths.get(Utils.CONFIG_PROPS.getProperty("data-store-path"),FILENAME);
        try{
            if(!Files.exists(userFile)) Files.createFile(userFile);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(userFile.toAbsolutePath().toString());
        }
    }
    @Override
    public boolean addUser(User u) {
        return FileOperations.saveRecordToFile(userFile,u.toString());
    }

    @Override
    public boolean updateUser(User u) {
        return deleteUser(u) & addUser(u);
    }

    @Override
    public boolean deleteUser(User u) {
        String uid = "u" + u.getId();
        return FileOperations.deleteRecordFromFile(userFile,uid);
    }

    @Override
    public User getUserByUserName(String userName) {
        List<String> ls = FileOperations.loadRecordsFromFile(userFile,userName);
        if(ls.size() == 0) return null;
        else {
            String s = ls.get(0);
            return new User(s);
        }
    }

    @Override
    public User getUserByUserId(long id) {
        String uid = "u"+id;
        String s = FileOperations.loadRecordsFromFile(userFile,uid).get(0);
        return new User(s);
    }
}
