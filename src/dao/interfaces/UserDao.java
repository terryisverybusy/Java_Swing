package dao.interfaces;

import dao.model.User;

public interface UserDao {
    boolean addUser(User u);
    boolean updateUser(User u);
    boolean deleteUser(User u);
    User getUserByUserName(String userName);
    User getUserByUserId(int id);
}