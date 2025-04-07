package dao;

import database.DatabaseConnection;
import model.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    private DatabaseConnection dbConnection;

    public TicketDAO() {
        dbConnection = new DatabaseConnection();
    }

    // Método para insertar un nuevo ticket
    public boolean insertTicket(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO Tickets (asunto, descripcion_problema, estado, fecha_apertura, fecha_resolucion, id_usuario, id_soporte_tecnico) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, ticket.getAsunto());
        statement.setString(2, ticket.getDescripcionProblema());
        statement.setString(3, ticket.getEstado());
        statement.setDate(4, new java.sql.Date(ticket.getFechaApertura().getTime()));
        statement.setDate(5, ticket.getFechaResolucion() != null ? new java.sql.Date(ticket.getFechaResolucion().getTime()) : null);
        statement.setInt(6, ticket.getIdUsuario());
        statement.setInt(7, ticket.getIdSoporteTecnico());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        dbConnection.closeConnection();
        return rowInserted;
    }

    // Método para listar todos los tickets
    public List<Ticket> listAllTickets() throws SQLException {
        List<Ticket> listTicket = new ArrayList<>();
        String sql = "SELECT * FROM Tickets";
        Connection connection = dbConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String asunto = resultSet.getString("asunto");
            String descripcionProblema = resultSet.getString("descripcion_problema");
            String estado = resultSet.getString("estado");
            Date fechaApertura = resultSet.getDate("fecha_apertura");
            Date fechaResolucion = resultSet.getDate("fecha_resolucion");
            int idUsuario = resultSet.getInt("id_usuario");
            int idSoporteTecnico = resultSet.getInt("id_soporte_tecnico");

            Ticket ticket = new Ticket(id, asunto, descripcionProblema, estado, fechaApertura, fechaResolucion, idUsuario, idSoporteTecnico);
            listTicket.add(ticket);
        }

        resultSet.close();
        statement.close();
        dbConnection.closeConnection();
        return listTicket;
    }

    // Método para actualizar un ticket
    public boolean updateTicket(Ticket ticket) throws SQLException {
        String sql = "UPDATE Tickets SET asunto = ?, descripcion_problema = ?, estado = ?, fecha_apertura = ?, fecha_resolucion = ?, id_usuario = ?, id_soporte_tecnico = ? WHERE id = ?";
        Connection connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, ticket.getAsunto());
        statement.setString(2, ticket.getDescripcionProblema());
        statement.setString(3, ticket.getEstado());
        statement.setDate(4, new java.sql.Date(ticket.getFechaApertura().getTime()));
        statement.setDate(5, ticket.getFechaResolucion() != null ? new java.sql.Date(ticket.getFechaResolucion().getTime()) : null);
        statement.setInt(6, ticket.getIdUsuario());
        statement.setInt(7, ticket.getIdSoporteTecnico());
        statement.setInt(8, ticket.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        dbConnection.closeConnection();
        return rowUpdated;
    }

    // Método para eliminar un ticket
    public boolean deleteTicket(int id) throws SQLException {
        String sql = "DELETE FROM Tickets WHERE id = ?";
        Connection connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        dbConnection.closeConnection();
        return rowDeleted;
    }
}