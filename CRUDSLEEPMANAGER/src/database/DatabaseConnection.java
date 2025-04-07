package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private String jdbcURL = "jdbc:mysql://localhost:3306/sleep_manager"; // Cambia según tu configuración
    private String jdbcUsername = "root"; // Cambia según tu configuración
    private String jdbcPassword = "79138426500"; // Cambia según tu configuración
    private Connection jdbcConnection;

    public Connection getConnection() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
        return jdbcConnection;
    }

    public void closeConnection() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
}