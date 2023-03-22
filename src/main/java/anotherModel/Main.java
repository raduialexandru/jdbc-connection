package anotherModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String HOST_NAME = "jdbc:mysql://localhost:3306/world";
    public static final String USER_NAME = "root";
    public static final String USER_PASSWORD = "Lollypop21";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(DRIVER_NAME);

        try (Connection connection = DriverManager.getConnection(HOST_NAME, USER_NAME, USER_PASSWORD)) {
            getCityList(connection).stream().forEach(city -> System.out.println(city));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<City> getCityList(Connection connection) {
        List<City> cities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM city LIMIT 10";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                Integer id = result.getInt("id");
                String name = result.getString("name");
                String countryCode = result.getString("countryCode");
                String district = result.getString("district");
                Integer population = result.getInt("population");

                cities.add(new City(id, name, countryCode, district, population));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cities;
    }
}
