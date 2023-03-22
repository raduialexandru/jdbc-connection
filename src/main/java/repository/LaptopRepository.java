package repository;

import model.Laptop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaptopRepository implements JdbcRepository {

    private final Connection connection;

    public LaptopRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTable() {
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

    @Override
    public void delete(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM laptop WHERE id = ";
            statement.execute(query + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readAll() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM laptop";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                Integer id = result.getInt("id");
                String model = result.getString("model");
                Integer processorId = result.getInt("processor_id");
                Integer motherboardId = result.getInt("motherboard_id");
                Integer ramMemoryGb = result.getInt("ram_memory_gb");
                Integer hardMemoryGb = result.getInt("hard_memory_gb");
                Integer displaySize = result.getInt("display_size");
                Boolean webCamera = result.getBoolean("web_camera");

                System.out.println("###########");
                System.out.println("Id: " + id);
                System.out.println("Model: " + model);
                System.out.println("Processor Id: " + processorId);
                System.out.println("Motherboard Id: " + motherboardId);
                System.out.println("Ram Memory (GB): " + ramMemoryGb);
                System.out.println("Hard Memory (GB): " + hardMemoryGb);
                System.out.println("Display size: " + displaySize);
                System.out.println("Web camera: " + webCamera);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readById(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM laptop WHERE id = " + id;
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                    String model = result.getString("model");
                    Integer processorId = result.getInt("processor_id");
                    Integer motherboardId = result.getInt("motherboard_id");
                    Integer ramMemoryGb = result.getInt("ram_memory_gb");
                    Integer hardMemoryGb = result.getInt("hard_memory_gb");
                    Integer displaySize = result.getInt("display_size");
                    Boolean webCamera = result.getBoolean("web_camera");

                    System.out.println("###########");
                    System.out.println("Id: " + id);
                    System.out.println("Model: " + model);
                    System.out.println("Processor Id: " + processorId);
                    System.out.println("Motherboard Id: " + motherboardId);
                    System.out.println("Ram Memory (GB): " + ramMemoryGb);
                    System.out.println("Hard Memory (GB): " + hardMemoryGb);
                    System.out.println("Display size: " + displaySize);
                    System.out.println("Web camera: " + webCamera);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, String... line) {

    }

    @Override
    public void save(String... line) {

    }
    
}
