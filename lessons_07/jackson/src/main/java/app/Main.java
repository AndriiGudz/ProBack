package app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import app.controllers.MyController;
import app.entities.Book;

import java.util.List;


public class Main {
    public static String json;
    public static String json1;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("app");
        MyController controller = context.getBean(MyController.class);
        System.out.println(controller.findAllBooks());

        Book savedBook = controller.save(new Book(null, "Generation Pi", "Pelevin", 1995));

        System.out.println(savedBook);
        System.out.printf("=======Result=======");
        System.out.println(controller.findAllBooks());

//        Book foundBook = controller.findBookById(savedBook.getId());
//        System.out.println(foundBook);


        ObjectMapper mapper = new ObjectMapper();
        try {
            // object to json
            json1 = mapper.writeValueAsString(controller.findAllBooks().get(0));

            // list of object to json
            json = mapper.writeValueAsString(controller.findAllBooks());
            System.out.println(json1);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {

            //json to object
            System.out.println(mapper.readValue(json1, Book.class));

            // json to list of object
            System.out.println(mapper.readValue(json, new TypeReference<List<Book>>() {}));
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}