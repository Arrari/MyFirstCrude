package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List getAllUsers();
    public User getUserById(int id);
    public boolean saveUser(User user);
    public boolean deleteUserById(int id);
}
