package model;

import java.util.Date;

public class Feedback {
    private int id;
    private String comentarios;
    private int puntuacion;
    private Date fechaEnvio;
    private String tipo;
    private int idUsuario;

    public Feedback(int id, String comentarios, int puntuacion, Date fechaEnvio, String tipo, int idUsuario) {
        this.id = id;
        this.comentarios = comentarios;
        this.puntuacion = puntuacion;
        this.fechaEnvio = fechaEnvio;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }
    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }
    public Date getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(Date fechaEnvio) { this.fechaEnvio = fechaEnvio; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
}