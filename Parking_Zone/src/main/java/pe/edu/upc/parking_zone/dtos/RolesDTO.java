package pe.edu.upc.parking_zone.dtos;

import pe.edu.upc.parking_zone.entities.Users;

public class RolesDTO {

    private Long idRol;

    private String rol;

    private String descriptionRol;

    private Users user;

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
