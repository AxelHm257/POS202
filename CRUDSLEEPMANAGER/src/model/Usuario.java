package model;

public class Usuario {
    private int id;
    private String nombre;
    private String ap;
    private String am;
    private int edad;
    private String correo;
    private String telefono;
    private String fechanacimiento;
    private String nivelestudios;
    private String contraseña;
    private int idgenero;

    // Constructor
    public Usuario(int id, String nombre, String ap, String am, int edad, String correo, String telefono, String fechanacimiento, String nivelestudios, String contraseña, int idgenero) {
        this.id = id;
        this.nombre = nombre;
        this.ap = ap;
        this.am = am;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.fechanacimiento = fechanacimiento;
        this.nivelestudios = nivelestudios;
        this.contraseña = contraseña;
        this.idgenero = idgenero;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getAp() { return ap; }
    public void setAp(String ap) { this.ap = ap; }
    public String getAm() { return am; }
    public void setAm(String am) { this.am = am; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getFechanacimiento() { return fechanacimiento; }
    public void setFechanacimiento(String fechanacimiento) { this.fechanacimiento = fechanacimiento; }
    public String getNivelestudios() { return nivelestudios; }
    public void setNivelestudios(String nivelestudios) { this.nivelestudios = nivelestudios; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public int getIdgenero() { return idgenero; }
    public void setIdgenero(int idgenero) { this.idgenero = idgenero; }
}