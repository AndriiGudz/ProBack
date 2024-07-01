import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Подключение к БД умпешно!");
            List<User> users = findAll(connection);
            for (User user : users) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<User> findAll(Connection connection) {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM t_user";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString("email");
                String password = resultSet.getString(4);
                users.add(new User(id, name, email, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
