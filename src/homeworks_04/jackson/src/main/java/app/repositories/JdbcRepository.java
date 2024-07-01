package app.repositories;

import app.entities.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource("classpath:application.properties")
public class JdbcRepository implements MyRepository {
    @Value("${db.driver}")
    private String DRIVER;

    @Value("${db.url}")
    private String url;

    @Value("${db.dbname}")
    private String dbname;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    private void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(String.format("Driver not found: %s", DRIVER), e);
        }
    }

    private Connection getConnection() {
        try {
            loadDriver();
            Connection connection = DriverManager.getConnection(url + dbname, username, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Create connection fail", e);
        }
    }

    @Override
    public List<Book> findAll() {
        String query = "SELECT * FROM book_table";
        try (Connection connection = getConnection()) {
            if (connection == null) {
                throw new RuntimeException("Failed to create connection");
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Book> result = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int year = resultSet.getInt("year");
                result.add(new Book(id, title, author, year));
            }
                return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        return null;
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            return create(book);
        } else {
            //Todo implements update
            return null;
        }
    }

    private Book create(Book book) {
//        String query = String.format("INSERT INTO book (title, author, year) VALUES (%s, %s, %d);",
//                book.getTitle(), book.getAuthor(), book.getYear());
        String query = "INSERT INTO book_table (title, author, year) VALUES (?, ?, ?);";
        try (Connection connection = getConnection()) {

            if (connection == null) {
                throw new RuntimeException("Create connection fail");
            }

            // Prepare query statement
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());

            int affectedRows = statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (!resultSet.next()) {
                throw new RuntimeException("Create book fail");
            } else {
                book.setId(resultSet.getLong(1));
                return book;
            }

        } catch (SQLException e) {
            throw  new RuntimeException("Create new book fail", e);
        }
    }
}
