package lessons_03.app.config;

import lessons_03.app.repository.ProductRepository;
import lessons_03.app.repository.ProductRepositoryListImpl;
import lessons_03.app.repository.ProductRepositoryMapImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    private final String repositoryType;

    public AppConfig(@Value("${repository.type}") String repositoryType) {
        this.repositoryType = repositoryType;
    }

    @Bean
    public ProductRepository getProductRepository() {
     if (repositoryType.equals("list")) {
         return new ProductRepositoryListImpl();
     }
     return new ProductRepositoryMapImpl();
    }

}
