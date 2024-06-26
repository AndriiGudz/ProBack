package lessons_03;

import lessons_03.app.controller.ProductController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("lessons_03.app");
        ProductController controller = context.getBean(ProductController.class);
        System.out.println(controller.getAllProducts());

    }
}
