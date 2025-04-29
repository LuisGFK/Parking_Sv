package pe.edu.upc.parking_zone.servicesinterfaces;

import pe.edu.upc.parking_zone.entities.Roles;

import java.util.List;

public interface IRolesService {
    public List<Roles> list();
    public void insert(Roles r);
    public Roles listId(Long id);
    public void update(Roles r);
    public void delete(Long id);

}
