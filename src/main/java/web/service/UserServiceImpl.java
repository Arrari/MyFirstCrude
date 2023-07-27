package web.service;

import web.DAO.UserDao;
import web.DAO.UserDaoImpl;
import web.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();

    @Override
    public List<User> getAllUsers() {
        return ud.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return ud.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        ud.saveUser(user);

    }

    @Override
    public void updateUser(User user) {
        ud.updateUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        ud.deleteUserById(id);
    }
}
