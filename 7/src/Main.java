import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String DB_USER = "postgres";
    static final String DB_PASSWORD = "1";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Menu menu = new Menu(connection);
            menu.displayMenuCommands();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
