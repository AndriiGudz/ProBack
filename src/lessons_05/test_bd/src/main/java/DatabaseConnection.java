import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String url ="jdbc:postgresql://localhost:5432/backend_db";
    private static final String username = "andrii_g";
    private static final String password = "qwerty";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
