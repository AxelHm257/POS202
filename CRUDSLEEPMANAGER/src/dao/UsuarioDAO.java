package dao;

import database.DatabaseConnection;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private DatabaseConnection dbConnection;

    public UsuarioDAO() {
        dbConnection = new DatabaseConnection();
    }

    public boolean insertUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuarios (Nombre, Ap, Am, Edad, Correo, Telefono, Fechanacimiento, Nivelestudios, Contraseña, idgenero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNombre());
        statement.setString(2, usuario.getAp());
        statement.setString(3, usuario.getAm());
        statement.setInt(4, usuario.getEdad());
        statement.setString(5, usuario.getCorreo());
        statement.setString(6, usuario.getTelefono());
        statement.setString(7, usuario.getFechanacimiento());
        statement.setString(8, usuario.getNivelestudios());
        statement.setString(9, usuario.getContraseña());
        statement.setInt(10, usuario.getIdgenero());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        dbConnection.closeConnection();
        return rowInserted;
    }

    public List<Usuario> listAllUsuarios() throws SQLException {
        List<Usuario> listUsuario = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        Connection connection = dbConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("Nombre");
            String ap = resultSet.getString("Ap");
            String am = resultSet.getString("Am");
            int edad = resultSet.getInt("Edad");
            String correo = resultSet.getString("Correo");
            String telefono = resultSet.getString("Telefono");
            String fechanacimiento = resultSet.getString("Fechanacimiento");
            String nivelestudios = resultSet.getString("Nivelestudios");
            String contraseña = resultSet.getString("Contraseña");
            int idgenero = resultSet.getInt("idgenero");

            Usuario usuario = new Usuario(id, nombre, ap, am, edad, correo, telefono, fechanacimiento, nivelestudios, contraseña, idgenero);
            listUsuario.add(usuario);
        }

        resultSet.close();
        statement.close();
        dbConnection.closeConnection();
        return listUsuario;
    }

    public boolean updateUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuarios SET Nombre=?, Ap=?, Am=?, Edad=?, Correo=?, Telefono=?, Fechanacimiento=?, Nivelestudios=?, Contraseña=?, idgenero=? WHERE id=?";
        Connection connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNombre());
        statement.setString(2, usuario.getAp());
        statement.setString(3, usuario.getAm());
        statement.setInt(4, usuario.getEdad());
        statement.setString(5, usuario.getCorreo());
        statement.setString(6, usuario.getTelefono());
        statement.setString(7, usuario.getFechanacimiento());
        statement.setString(8, usuario.getNivelestudios());
        statement.setString(9, usuario.getContraseña());
        statement.setInt(10, usuario.getIdgenero());
        statement.setInt(11, usuario.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        dbConnection.closeConnection();
        return rowUpdated;
    }

    public boolean deleteUsuario(int id) throws SQLException {
        String sql = "DELETE FROM Usuarios WHERE id=?";
        Connection connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        dbConnection.closeConnection();
        return rowDeleted;
    }
}