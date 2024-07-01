package app.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import app.entities.Book;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FirstRepository implements MyRepository{

    private final List<Book> books = List.of(new Book("Книга 1", "Автор 1", 2000),
            new Book("Книга 2", "Автор 2", 1900),
            new Book("Книга 3", "Автор 1", 1860)
    );

    @Override
    public List<Book> findAll() {
        return List.copyOf(books);
    }
}
