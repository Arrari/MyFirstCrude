package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void saveUser(User user);
    public void updateUser(User user);

    public void deleteUserById(int id);

}
