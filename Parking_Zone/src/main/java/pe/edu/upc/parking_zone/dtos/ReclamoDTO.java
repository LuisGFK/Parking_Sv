package pe.edu.upc.parking_zone.dtos;

import pe.edu.upc.parking_zone.entities.Reserva;
import pe.edu.upc.parking_zone.entities.Users;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReclamoDTO {

    private int idReclamo;

    private String titulo;

    private String descripcion;

    private Boolean archivo;

    private LocalDate fecha;

    private String estado;

    private LocalTime hora;

    private Users user;

    private Reserva reserva;

    public int getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(int idReclamo) {
        this.idReclamo = idReclamo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getArchivo() {
        return archivo;
    }

    public void setArchivo(Boolean archivo) {
        this.archivo = archivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
