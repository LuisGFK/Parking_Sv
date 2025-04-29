package pe.edu.upc.parking_zone.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="Notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;
    @Column(name = "mensaje", length = 45, nullable = false)
    private String mensaje;
    @Column(name = "fechaEmision", nullable = false)
    private LocalDate fechaEmision;
    @Column(name = "fechaProgramada", nullable = false)
    private LocalDate fechaProgramada;
    @Column(name = "estado", length= 50, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "idTipoNotificacion")
    private TipoNotificacion tipoNotificacion;

    @ManyToOne
    @JoinColumn(name = "idReserva")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "idReclamo")
    private Reclamo reclamo;

    public Notificacion() {

    }

    public Notificacion(int idNotificacion, String mensaje, LocalDate fechaEmision, LocalDate fechaProgramada, String estado, Users user, TipoNotificacion tipoNotificacion, Reserva reserva, Reclamo reclamo) {
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
        this.fechaEmision = fechaEmision;
        this.fechaProgramada = fechaProgramada;
        this.estado = estado;
        this.user = user;
        this.tipoNotificacion = tipoNotificacion;
        this.reserva = reserva;
        this.reclamo = reclamo;
    }

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
