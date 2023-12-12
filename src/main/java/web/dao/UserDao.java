package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void persistUser(User user);
    public void updateUser(User user, int id);
    public void deleteUserById(int id);
}
