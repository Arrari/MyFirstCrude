package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = em.createQuery("from User", User.class).getResultList();
        return userList;
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void persistUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User updatedUser, int id) {
        User userToUpdate = getUserById(id);
        userToUpdate.setFirstName(updatedUser.getFirstName());
        userToUpdate.setLastName(updatedUser.getLastName());
        userToUpdate.setEmail(updatedUser.getEmail());
        userToUpdate.setUserName(updatedUser.getUserName());
    }

    @Override
    public void deleteUserById(int id) {
        User userForDeletion = em.find(User.class, id);
        if (userForDeletion != null) {
            em.remove(userForDeletion);
        }
    }
}
