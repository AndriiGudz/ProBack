package app.repositories;

import app.entities.Book;

import java.util.List;

public interface MyRepository {
    List<Book> findAll();
}