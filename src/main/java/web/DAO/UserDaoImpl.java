package web.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceUnit
    private EntityManager em;

    @Override
    public List getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUserById(int id) {
        return false;
    }
}
