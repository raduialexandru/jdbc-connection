package repository;

public interface JdbcRepository {

    void createTable();
    void delete(int id);
    void readAll();
    void readById(int id);
    void update(int id, String... line);
    void save(String... line);

}
