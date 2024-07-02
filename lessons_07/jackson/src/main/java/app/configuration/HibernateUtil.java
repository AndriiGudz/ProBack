package app.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {

    private Environment env;
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateUtil(Environment env) {
        this.env = env;
        init();
    }

    private void init() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", env.getProperty("db.driver"));
        configuration.setProperty("hibernate.connection.url", env.getProperty("db.url")+ env.getProperty("db.dbname"));
        configuration.setProperty("hibernate.connection.username", env.getProperty("db.username"));
        configuration.setProperty("hibernate.connection.password", env.getProperty("db.password"));
//        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "true");

        configuration.addAnnotatedClass(app.entities.Book.class);
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

