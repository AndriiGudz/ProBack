package app.repositories;

import app.configuration.HibernateUtil;
import app.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateRepository implements MyRepository{

    private final EntityManager entityManager;
    private final HibernateUtil hibernateUtil;

    @Autowired
    private HibernateRepository(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
         entityManager = hibernateUtil
                 .getSessionFactory()
                 .createEntityManager();
    }


    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("from Book", Book.class).getResultList();
    }

    @Override
    public Book save(Book book) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction.isActive()){
                transaction.rollback();
            }
            throw new RuntimeException("Save book failed", e);
        }
    }

    @Override
    public Book findById(Long id) {
        return null;
    }
}
