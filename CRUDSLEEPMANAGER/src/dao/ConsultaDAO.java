package dao;

import database.DatabaseConnection;
import model.Consulta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    private DatabaseConnection dbConnection;

    public ConsultaDAO() {
        dbConnection = new DatabaseConnection();
    }

    public boolean insertConsulta(Consulta consulta) throws SQLException {
        String sql = "INSERT INTO consulta (id_tipo, descripcion, fecha, estado, respuesta, id_usuario, id_soporte_tecnico) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, consulta.getIdTipo());
            statement.setString(2, consulta.getDescripcion());
            statement.setDate(3, new java.sql.Date(consulta.getFecha().getTime()));
            statement.setString(4, consulta.getEstado());
            statement.setString(5, consulta.getRespuesta());
            statement.setInt(6, consulta.getIdUsuario());
            statement.setInt(7, consulta.getIdSoporteTecnico());

            return statement.executeUpdate() > 0;
        }
    }

    public boolean updateConsulta(Consulta consulta) throws SQLException {
        String sql = "UPDATE consulta SET id_tipo = ?, descripcion = ?, fecha = ?, estado = ?, respuesta = ?, id_usuario = ?, id_soporte_tecnico = ? WHERE id = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, consulta.getIdTipo());
            statement.setString(2, consulta.getDescripcion());
            statement.setDate(3, new java.sql.Date(consulta.getFecha().getTime()));
            statement.setString(4, consulta.getEstado());
            statement.setString(5, consulta.getRespuesta());
            statement.setInt(6, consulta.getIdUsuario());
            statement.setInt(7, consulta.getIdSoporteTecnico());
            statement.setInt(8, consulta.getId());

            return statement.executeUpdate() > 0;
        }
    }

    public List<Consulta> listAllConsultas() throws SQLException {
        List<Consulta> listConsultas = new ArrayList<>();
        String sql = "SELECT * FROM consulta";
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idTipo = resultSet.getInt("id_tipo");
                String descripcion = resultSet.getString("descripcion");
                Date fecha = resultSet.getDate("fecha");
                String estado = resultSet.getString("estado");
                String respuesta = resultSet.getString("respuesta");
                int idUsuario = resultSet.getInt("id_usuario");
                int idSoporteTecnico = resultSet.getInt("id_soporte_tecnico");

                Consulta consulta = new Consulta(id, idTipo, descripcion, fecha, estado, respuesta, idUsuario, idSoporteTecnico);
                listConsultas.add(consulta);
            }
        }
        return listConsultas;
    }

    public Consulta getConsultaById(int id) throws SQLException {
        String sql = "SELECT * FROM consulta WHERE id = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idTipo = resultSet.getInt("id_tipo");
                String descripcion = resultSet.getString("descripcion");
                Date fecha = resultSet.getDate("fecha");
                String estado = resultSet.getString("estado");
                String respuesta = resultSet.getString("respuesta");
                int idUsuario = resultSet.getInt("id_usuario");
                int idSoporteTecnico = resultSet.getInt("id_soporte_tecnico");

                return new Consulta(id, idTipo, descripcion, fecha, estado, respuesta, idUsuario, idSoporteTecnico);
            }
        }
        return null; // Retorna null si no se encuentra la consulta
        
    }
    public boolean deleteConsulta(int id) throws SQLException {
    String sql = "DELETE FROM consulta WHERE id = ?";
    try (Connection connection = dbConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);
        return statement.executeUpdate() > 0; // Devuelve true si se eliminó al menos una fila
    }
}
}