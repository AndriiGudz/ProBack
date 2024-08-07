package app.repositories;

import app.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateRepository implements MyRepository{

    private final EntityManager entityManager;

    private HibernateRepository() {
         entityManager = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
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
