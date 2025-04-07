package dao;

import database.DatabaseConnection;
import model.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    private DatabaseConnection dbConnection;

    public FeedbackDAO() {
        dbConnection = new DatabaseConnection();
    }

    // Método para insertar un nuevo feedback
    public boolean insertFeedback(Feedback feedback) throws SQLException {
        String sql = "INSERT INTO feedback (comentarios, puntuacion, fecha_envio, tipo, id_usuario) VALUES (?, ?, ?, ?, ?)";
        Connection connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, feedback.getComentarios());
        statement.setInt(2, feedback.getPuntuacion());
        statement.setDate(3, new java.sql.Date(feedback.getFechaEnvio().getTime()));
        statement.setString(4, feedback.getTipo());
        statement.setInt(5, feedback.getIdUsuario());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        dbConnection.closeConnection();
        return rowInserted;
    }

    // Método para listar todos los feedbacks
    public List<Feedback> listAllFeedbacks() throws SQLException {
        List<Feedback> listFeedback = new ArrayList<>();
        String sql = "SELECT * FROM feedback";
        Connection connection = dbConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String comentarios = resultSet.getString("comentarios");
            int puntuacion = resultSet.getInt("puntuacion");
            Date fechaEnvio = resultSet.getDate("fecha_envio");
            String tipo = resultSet.getString("tipo");
            int idUsuario = resultSet.getInt("id_usuario");

            Feedback feedback = new Feedback(id, comentarios, puntuacion, fechaEnvio, tipo, idUsuario);
            listFeedback.add(feedback);
        }

        resultSet.close();
        statement.close();
        dbConnection.closeConnection();
        return listFeedback;
    }

    // Método para actualizar un feedback
    public boolean updateFeedback(Feedback feedback) throws SQLException {
        String sql = "UPDATE feedback SET comentarios = ?, puntuacion = ?, fecha_envio = ?, tipo = ?, id_usuario = ? WHERE id = ?";
        Connection connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, feedback.getComentarios());
        statement.setInt(2, feedback.getPuntuacion());
        statement.setDate(3, new java.sql.Date(feedback.getFechaEnvio().getTime()));
        statement.setString(4, feedback.getTipo());
        statement.setInt(5, feedback.getIdUsuario());
        statement.setInt(6, feedback.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        dbConnection.closeConnection();
        return rowUpdated;
    }

    // Método para eliminar un feedback
    public boolean deleteFeedback(int id) throws SQLException {
        String sql = "DELETE FROM feedback WHERE id = ?";
        Connection connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        dbConnection.closeConnection();
        return rowDeleted;
    }
}