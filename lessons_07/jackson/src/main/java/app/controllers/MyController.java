package app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import app.entities.Book;
import app.services.MyService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MyController {

    private final MyService myService;

    public List<Book> findAllBooks(){
        return myService.findAll();
    }

    public Book save(Book book) {
        return myService.save(book);
    }

    public Book findBookById(@PathVariable Long id) {
        return myService.findById(id);
    }
}
