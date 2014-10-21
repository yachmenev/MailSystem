package jmail.dao;

import jmail.model.Letter;
import jmail.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 14.10.14.
 */
public class LetterDaoImpHibernate implements LetterDao {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_unit");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public Letter findById(int id) {
        Letter letter = entityManager.find(Letter.class, id);
        return letter;
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
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(letter);
        transaction.commit();
    }

    @Override
    public void update(int id, Letter letter) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Letter new_letter = entityManager.find(Letter.class, id);
        if (letter.getTitle() != null){
            new_letter.setTitle(letter.getTitle());
        }
        if (letter.getBody() != null){
            new_letter.setBody(letter.getBody());
        }
        if (letter.getTo() != null){
            new_letter.setTo(letter.getTo());
        }
        if (letter.getFrom() != null){
            new_letter.setFrom(letter.getFrom());
        }

        entityManager.merge(new_letter);
        transaction.commit();

    }

    @Override
    public void delete(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        LetterDao letterDao = new LetterDaoImpHibernate();
        Letter letter = letterDao.findById(id);
        entityManager.remove(letter);
        transaction.commit();
    }

    @Override
    public List<Letter> allByUserLogin(String login) {
        UserDao userDao = new UserDaoImpHibernate();
        User user = userDao.find(login);
        Query query = entityManager.createQuery
                ("SELECT l FROM Letter l WHERE l.from= :from_user OR l.to= :to_user");
        query.setParameter("from_user", user.getId());
        query.setParameter("to_user", user.getId());
        List<Letter> list = query.getResultList();
        return list;
    }
}