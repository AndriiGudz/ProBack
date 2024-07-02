package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import app.entities.Book;
import app.repositories.MyRepository;

import java.util.List;

@Service
@PropertySource("classpath:application.properties")
//@RequiredArgsConstructor
public class MyService {

    private final MyRepository myRepository;

    @Autowired
    public MyService(@Value("${jdbc}") String repositoryType,
                     @Qualifier("firstRepository") MyRepository firstRepository,
                     @Qualifier("secondRepository") MyRepository secondRepository,
                     @Qualifier("jdbcRepository") MyRepository thirdRepository,
                     @Qualifier("hibernateRepository") MyRepository forthRepository) {
        if (repositoryType.equals("firstRepository")) {
            this.myRepository = firstRepository;
        } else if (repositoryType.equals("secondRepository"))  {
            this.myRepository = secondRepository;
        } else if(repositoryType.equals("jdbc")) {
            this.myRepository = thirdRepository;
        } else {
            this.myRepository = forthRepository;
        }
    }

    public List<Book> findAll(){
        return myRepository.findAll();
    }

    public Book save(Book book) {
        return myRepository.save(book);
    }

    public Book findById(Long id) {
        return myRepository.findById(id);
    }
}
