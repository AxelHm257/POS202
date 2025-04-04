import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserCRUD {
    
    private Connection conexion;
    
    public UserCRUD(){
        conexion = ConexionMySQL.conectar();
        
    }
    
    public boolean crearUsuario(String nom, String cor, String contra){
    
        String sqlInsert = "INSERT INTO usuarios(Nombre,Correo,Contrasena) VALUE(?,?,?)";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sqlInsert);
            ps.setString(1, nom);
            ps.setString(2, cor);
            ps.setString(3, contra);
            return ps.executeUpdate() > 0; 
        }
        
        catch(SQLException e){
            System.out.print("Error al intentar insertar: "+ e.getMessage());
            return false;
        }
    } //fin del insert
    
    public ResultSet obtenerUsuarioPorId(int id){
        String selectSql= "SELECT * FROM Usuarios WHERE ID = ?";
        
        try {
            PreparedStatement ps= conexion.prepareStatement(selectSql);
            ps.setInt(1, id);
            return ps.executeQuery();
        }
        catch(SQLException e){
            System.out.print("Error al intentar consultar: "+ e.getMessage());
            return null;
        }
    } // Obtener usuario po rid
    
    public ResultSet obtenerTodos(){
        String sqlTodos = " SELECT * FROM Usuarios";
        
        try{
           PreparedStatement ps= conexion.prepareStatement(sqlTodos);
           return ps.executeQuery();
        }
        catch(SQLException w){
            System.out.println("Error al consultar" + w.getMessage());
            return null;
        }
    }
    
public boolean actualizarUsuario(int id, String nom, String cor, String contra) {
    String sqlUpdate = "UPDATE Usuarios SET Nombre=?, Correo=?, Contrasena=? WHERE ID=?";
    
    try {
        PreparedStatement ps = conexion.prepareStatement(sqlUpdate);
        ps.setString(1, nom);
        ps.setString(2, cor);
        ps.setString(3, contra);
        ps.setInt(4, id); // ID se usa solo para encontrar el usuario
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error al actualizar: " + e.getMessage());
        return false;
    }
}
    
}   