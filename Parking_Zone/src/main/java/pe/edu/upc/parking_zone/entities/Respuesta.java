package pe.edu.upc.parking_zone.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Respuesta")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;
    @Column(name="fecha",nullable=false)
    private LocalDate fecha;
    @Column(name="hora",nullable=false)
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "idReclamo")

    private Reclamo reclamo;

    public Respuesta() {

    }

    public Respuesta(int idRespuesta, LocalDate fecha, LocalTime hora, Reclamo reclamo) {
        this.idRespuesta = idRespuesta;
        this.fecha = fecha;
        this.hora = hora;
        this.reclamo = reclamo;
    }

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
