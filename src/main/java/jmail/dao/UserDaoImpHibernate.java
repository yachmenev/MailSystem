package jmail.dao;

import jmail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Admin on 14.10.14.
 */
@Repository
public class UserDaoImpHibernate implements UserDao {

    @Autowired
    private EntityManagerFactory factory = null;

    @Override
    public User findById(int id) {
        EntityManager entityManager = factory.createEntityManager();
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public User find(String login) {
        EntityManager entityManager = factory.createEntityManager();
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
    @Transactional
    public void create(User user) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
    }

    @Override
    @Transactional
    public boolean update(User user) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(user);
        transaction.commit();
        return true;
    }

    @Override
    @Transactional
    public boolean delete(String login) {
        EntityManager entityManager = factory.createEntityManager();
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
        EntityManager entityManager = factory.createEntityManager();
        try{
            Query query = entityManager.createQuery
                    ("SELECT u FROM User u");
            List<User> list = query.getResultList();
            return list;
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}