package pe.edu.upc.parking_zone.dtos;


import pe.edu.upc.parking_zone.entities.Empresa;

public class EstacionamientoDTO {

    private int idEstacionamiento;

    private String nombre;

    private String direccion;

    private String tipoEstacionamiento;

    private double tarifaHora;

    private String capacidad;

    private String estadoEstacionamiento;

    private double latitud;

    private double longitud;

    private String reservaDiaria;

    private double montoTotalDiario;

    private boolean empresaMasReservada;

    private Empresa empresa;

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
