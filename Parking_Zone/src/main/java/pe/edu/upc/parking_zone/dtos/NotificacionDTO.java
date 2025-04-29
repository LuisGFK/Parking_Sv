package pe.edu.upc.parking_zone.dtos;

import pe.edu.upc.parking_zone.entities.Reclamo;
import pe.edu.upc.parking_zone.entities.Reserva;
import pe.edu.upc.parking_zone.entities.TipoNotificacion;
import pe.edu.upc.parking_zone.entities.Users;

import java.time.LocalDate;

public class NotificacionDTO {

    private int idNotificacion;

    private String mensaje;

    private LocalDate fechaEmision;

    private LocalDate fechaProgramada;

    private String estado;

    private Users user;

    private TipoNotificacion tipoNotificacion;

    private Reserva reserva;

    private Reclamo reclamo;

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(LocalDate fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public TipoNotificacion getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(TipoNotificacion tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }
}
