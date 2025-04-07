package model;

import java.util.Date;

public class Ticket {
    private int id;
    private String asunto;
    private String descripcionProblema;
    private String estado;
    private Date fechaApertura;
    private Date fechaResolucion;
    private int idUsuario;
    private int idSoporteTecnico;

    public Ticket(int id, String asunto, String descripcionProblema, String estado, Date fechaApertura, Date fechaResolucion, int idUsuario, int idSoporteTecnico) {
        this.id = id;
        this.asunto = asunto;
        this.descripcionProblema = descripcionProblema;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.fechaResolucion = fechaResolucion;
        this.idUsuario = idUsuario;
        this.idSoporteTecnico = idSoporteTecnico;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }
    
    public String getDescripcionProblema() { return descripcionProblema; }
    public void setDescripcionProblema(String descripcionProblema) { this.descripcionProblema = descripcionProblema; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public Date getFechaApertura() { return fechaApertura; }
    public void setFechaApertura(Date fechaApertura) { this.fechaApertura = fechaApertura; }
    
    public Date getFechaResolucion() { return fechaResolucion; }
    public void setFechaResolucion(Date fechaResolucion) { this.fechaResolucion = fechaResolucion; }
    
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    
    public int getIdSoporteTecnico() { return idSoporteTecnico; }
    public void setIdSoporteTecnico(int idSoporteTecnico) { this.idSoporteTecnico = idSoporteTecnico; }
}