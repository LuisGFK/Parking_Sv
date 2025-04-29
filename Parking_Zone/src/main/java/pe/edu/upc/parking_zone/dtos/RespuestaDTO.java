package pe.edu.upc.parking_zone.dtos;

import pe.edu.upc.parking_zone.entities.Reclamo;

import java.time.LocalDate;
import java.time.LocalTime;

public class RespuestaDTO {

    private int idRespuesta;

    private LocalDate fecha;

    private LocalTime hora;

    private Reclamo reclamo;

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }
}
