package pe.edu.upc.parking_zone.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class RespuestaReclamoDTO {

    private String titulo;

    private LocalDate fecha;

    private LocalTime hora;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
}
