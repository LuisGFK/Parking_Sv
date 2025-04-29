package pe.edu.upc.parking_zone.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;
    @Column(name="fechaReserva", nullable=false)
    private LocalDate fechaReserva;
    @Column(name="estadoReserva", length = 30, nullable=false)
    private String estadoReserva;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name="idEstacionamiento")
    private Estacionamiento estacionamiento;

    public Reserva() {

    }

    public Reserva(int idReserva, LocalDate fechaReserva, String estadoReserva, Users user, Estacionamiento estacionamiento) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.estadoReserva = estadoReserva;
        this.user = user;
        this.estacionamiento = estacionamiento;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Estacionamiento getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(Estacionamiento estacionamiento) {
        this.estacionamiento = estacionamiento;
    }
}
