package app.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import app.entities.Book;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FirstRepository implements MyRepository{

    private final List<Book> books = List.of(new Book(1L, "Книга 1", "Автор 1", 2000),
            new Book(2L, "Книга 2", "Автор 2", 1900),
            new Book(3L, "Книга 3", "Автор 1", 1860)
    );

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return List.copyOf(books);
    }

    @Override
    public Book findById(Long id) {
        return null;
    }
}
