package mydatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {
    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String HOST_NAME = "jdbc:mysql://localhost:3306/world";
    public static final String USER_NAME = "root";
    public static final String USER_PASSWORD = "Lollypop21";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(DRIVER_NAME);

        try (Connection connection = DriverManager.getConnection(HOST_NAME, USER_NAME, USER_PASSWORD)) {
            create(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void create(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Laptop (\n" +
                    "id INT PRIMARY KEY,\n" +
                    "model VARCHAR(255),\n" +
                    "processor_id INT,\n" +
                    "motherboard_id INT,\n" +
                    "ram_memory_gb INT,\n" +
                    "hard_memory_gb INT,\n" +
                    "display_size INT,\n" +
                    "web_camera boolean\n" +
                    ");";
            statement.execute(createTableQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
