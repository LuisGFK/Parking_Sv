package pe.edu.upc.parking_zone.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","rol"})})
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name = "rol", nullable = false , length = 35)
    private String rol;

    @Column(name = "descriptionRol", nullable = false, length = 100)
    private String descriptionRol;
    //agregar el one to many para saber que rol esta asigando a cada usuario
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public Roles() {

    }

    public Roles(Long idRol, String rol, String descriptionRol, Users user) {
        this.idRol = idRol;
        this.rol = rol;
        this.descriptionRol = descriptionRol;
        this.user = user;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescriptionRol() {
        return descriptionRol;
    }

    public void setDescriptionRol(String descriptionRol) {
        this.descriptionRol = descriptionRol;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
