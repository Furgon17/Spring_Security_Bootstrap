package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> getListUsers();

    User getUserByName(String name);
}