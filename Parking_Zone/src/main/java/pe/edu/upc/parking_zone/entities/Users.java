package pe.edu.upc.parking_zone.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="UsersTable")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", nullable=false, length=35)
    private String username;

    @Column(name="password", nullable=false, length=200)
    private String password;

    private Boolean enabled;
    
    @Column(name ="apellido", length = 50, nullable = false)
    private String apellido;

    @Column(name ="correo", length = 75, nullable = false)
    private String correo;
    @Column(name ="telefono", length = 20, nullable = false)
    private String telefono;

    @Column(name = "tipoUsuario", length = 75, nullable = false)
    private String tipoUsuario;

    @Column(name ="latitud", nullable = false )
    private double latitud;

    @Column(name ="longitud", nullable = false )
    private double longitud;

    @Column(name="esNuevo", nullable=false)
    private Boolean esNuevo;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Roles> roles;

    public Users(){

    }

    public Users(Long id, String username, String password, Boolean enabled, String apellido, String correo, String telefono, String tipoUsuario, double latitud, double longitud, Boolean esNuevo, List<Roles> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.esNuevo = esNuevo;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public Boolean getEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(Boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
