package model;

import java.util.Date;

public class Consulta {
    private int id; // ID de la consulta
    private int idTipo; // ID del tipo de consulta
    private String descripcion; // Descripción de la consulta
    private Date fecha; // Fecha de la consulta
    private String estado; // Estado de la consulta
    private String respuesta; // Respuesta a la consulta
    private int idUsuario; // ID del usuario que realizó la consulta
    private int idSoporteTecnico; // ID del soporte técnico asignado a la consulta

    // Constructor
    public Consulta(int id, int idTipo, String descripcion, Date fecha, String estado, String respuesta, int idUsuario, int idSoporteTecnico) {
        this.id = id;
        this.idTipo = idTipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.respuesta = respuesta;
        this.idUsuario = idUsuario;
        this.idSoporteTecnico = idSoporteTecnico;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSoporteTecnico() {
        return idSoporteTecnico;
    }

    public void setIdSoporteTecnico(int idSoporteTecnico) {
        this.idSoporteTecnico = idSoporteTecnico;
    }
}