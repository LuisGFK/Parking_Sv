package pe.edu.upc.parking_zone.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Estacionamiento")
public class Estacionamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstacionamiento;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(name = "direccion", length = 50, nullable = false)
    private String direccion;
    @Column(name = "tipoEstacionamiento", length = 20, nullable = false)
    private String tipoEstacionamiento;
    @Column(name = "tarifaHora", nullable = false)
    private double tarifaHora;
    @Column(name = "capacidad", length = 50, nullable = false)
    private String capacidad;
    @Column(name = "estadoEstacionamiento", length = 20, nullable = false)
    private String estadoEstacionamiento;
    @Column(name = "latitud",nullable = false)
    private double latitud;
    @Column(name = "longitud",nullable = false)
    private double longitud;
    @Column(name="reservaDiaria",length = 20, nullable = false)
    private String reservaDiaria;
    @Column(name="montoTotalDiario",nullable = false)
    private double montoTotalDiario;
    @Column(name="empresaMasReservada",nullable = false)
    private boolean empresaMasReservada;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    public Estacionamiento() {

    }

    public Estacionamiento(int idEstacionamiento, String nombre, String direccion, String tipoEstacionamiento, double tarifaHora, String capacidad, String estadoEstacionamiento, double latitud, double longitud, String reservaDiaria, double montoTotalDiario, boolean empresaMasReservada, Empresa empresa) {
        this.idEstacionamiento = idEstacionamiento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoEstacionamiento = tipoEstacionamiento;
        this.tarifaHora = tarifaHora;
        this.capacidad = capacidad;
        this.estadoEstacionamiento = estadoEstacionamiento;
        this.latitud = latitud;
        this.longitud = longitud;
        this.reservaDiaria = reservaDiaria;
        this.montoTotalDiario = montoTotalDiario;
        this.empresaMasReservada = empresaMasReservada;
        this.empresa = empresa;
    }

    public int getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(int idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoEstacionamiento() {
        return tipoEstacionamiento;
    }

    public void setTipoEstacionamiento(String tipoEstacionamiento) {
        this.tipoEstacionamiento = tipoEstacionamiento;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstadoEstacionamiento() {
        return estadoEstacionamiento;
    }

    public void setEstadoEstacionamiento(String estadoEstacionamiento) {
        this.estadoEstacionamiento = estadoEstacionamiento;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getReservaDiaria() {
        return reservaDiaria;
    }

    public void setReservaDiaria(String reservaDiaria) {
        this.reservaDiaria = reservaDiaria;
    }

    public double getMontoTotalDiario() {
        return montoTotalDiario;
    }

    public void setMontoTotalDiario(double montoTotalDiario) {
        this.montoTotalDiario = montoTotalDiario;
    }

    public boolean isEmpresaMasReservada() {
        return empresaMasReservada;
    }

    public void setEmpresaMasReservada(boolean empresaMasReservada) {
        this.empresaMasReservada = empresaMasReservada;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
