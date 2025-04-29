package pe.edu.upc.parking_zone.dtos;

import pe.edu.upc.parking_zone.entities.Estacionamiento;
import pe.edu.upc.parking_zone.entities.Users;

import java.time.LocalDate;

public class ReservaDTO {

    private int idReserva;

    private LocalDate fechaReserva;

    private String estadoReserva;

    private Users user;

    private Estacionamiento estacionamiento;

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
