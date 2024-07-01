package app.repositories;

import app.entities.Book;

import java.util.List;

public class HibernateRepository implements MyRepository{



    @Override
    public List<Book> findAll() {
        System.out.println("hibernate");
        return null;
    }

    @Override
    public Book save(Book book) {
        return null;
    }
}
