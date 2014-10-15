package jmail.dao;

import jmail.model.Letter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 14.10.14.
 */
public class LetterDaoImpHibernat implements LetterDao {
    @Override
    public Letter findById(int id) {
        return null;
    }

    @Override
    public Letter findByDateRange(Date start, Date end) {
        return null;
    }

    @Override
    public List<Letter> findByKeyWord(String keyWord) {
        return null;
    }

    @Override
    public void create(Letter letter) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(letter);
        transaction.commit();
    }

    @Override
    public void update(Letter letter) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Letter> allByUserLogin(String login) {
        return null;
    }
}
