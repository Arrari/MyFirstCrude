package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceUnit
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createNamedQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUserById(int id) {
       User userForDeletion = em.find(User.class, id);
       if (userForDeletion != null) {
           em.remove(userForDeletion);
       }
    }
}
