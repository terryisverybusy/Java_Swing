package dao.interfaces;

import dao.model.User;

import java.util.List;

public interface UserDao {
    boolean addUser(User u);
    boolean updateUser(User u);
    boolean deleteUser(User u);
    User getUserByUserName(String userName);
    User getUserByUserId(long id);
}