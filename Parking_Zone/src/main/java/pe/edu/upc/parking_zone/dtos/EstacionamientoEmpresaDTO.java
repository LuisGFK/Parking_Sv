package pe.edu.upc.parking_zone.dtos;

public class EstacionamientoEmpresaDTO {

    private String nombreEmpresa;
    private String nombreEstacionamiento;
    private String direccion;
    private double tarifaHora;
    private int cantidadEstacionamientos;

    public EstacionamientoEmpresaDTO(String nombreEmpresa, String nombreEstacionamiento, String direccion, double tarifaHora, int cantidadEstacionamientos) {
        this.nombreEmpresa = nombreEmpresa;
        this.nombreEstacionamiento = nombreEstacionamiento;
        this.direccion = direccion;
        this.tarifaHora = tarifaHora;
        this.cantidadEstacionamientos = cantidadEstacionamientos;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreEstacionamiento() {
        return nombreEstacionamiento;
    }

    public void setNombreEstacionamiento(String nombreEstacionamiento) {
        this.nombreEstacionamiento = nombreEstacionamiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public int getCantidadEstacionamientos() {
        return cantidadEstacionamientos;
    }

    public void setCantidadEstacionamientos(int cantidadEstacionamientos) {
        this.cantidadEstacionamientos = cantidadEstacionamientos;
    }
}
