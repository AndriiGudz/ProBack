package app.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import app.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class SecondRepository implements MyRepository{

    private final Map<Long, Book> books = Map.of(
            1L, new Book(1L, "Книга Map1", "Автор 5", 1902),
            2L, new Book(2L, "Книга Map2", "Автор 7", 1200),
            3L, new Book(3L, "Книга Map3", "Автор 1", 1802)
    );

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book findById(Long id) {
        return null;
    }
}
