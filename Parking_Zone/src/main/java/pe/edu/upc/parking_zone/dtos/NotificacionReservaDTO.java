package pe.edu.upc.parking_zone.dtos;


import pe.edu.upc.parking_zone.entities.Reserva;

public class NotificacionReservaDTO {

    private int idNotificacionReserva;

    private Reserva reserva;

    public int getIdNotificacionReserva() {
        return idNotificacionReserva;
    }

    public void setIdNotificacionReserva(int idNotificacionReserva) {
        this.idNotificacionReserva = idNotificacionReserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
