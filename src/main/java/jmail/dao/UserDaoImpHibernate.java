package jmail.dao;

import jmail.model.User;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Admin on 14.10.14.
 */
public class UserDaoImpHibernate implements UserDao {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_unit");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public User findById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public User find(String login) {
        //Java Persistence Query Language
        try {
            Query query = entityManager.createQuery
                    ("SELECT u FROM User u WHERE u.login= :login");
            User user = (User) query.setParameter("login", login).getSingleResult();
            return user;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void create(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
    }

    @Override
    public boolean update(int id, User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User new_user = entityManager.find(User.class, id);
        new_user.setLogin(user.getLogin());
        new_user.setPass(user.getPass());

        entityManager.merge(new_user);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String login) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        UserDao userDao = new UserDaoImpHibernate();
        User user = userDao.find(login);
        entityManager.remove(user);
        transaction.commit();
        return true;
    }

    @Override
    public List<User> all() {
        Query query = entityManager.createQuery
                ("SELECT u FROM User u ");
        List<User> list = query.getResultList();
        return list;
    }
}