package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao ud;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.ud = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return ud.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return ud.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        ud.saveUser(user);

    }

    @Override
    @Transactional
    public void updateUser(User user, int id) {
        ud.updateUser(user, id);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        ud.deleteUserById(id);
    }
}
