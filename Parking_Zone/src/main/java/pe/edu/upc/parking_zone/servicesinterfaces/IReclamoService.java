package pe.edu.upc.parking_zone.servicesinterfaces;

import pe.edu.upc.parking_zone.entities.Reclamo;

import java.util.List;

public interface IReclamoService {
    public List<Reclamo> list();
    public void insert(Reclamo rm);
    public Reclamo listId(int id);
    public void update(Reclamo rm);
    public void delete(int id);
    public List<String[]> listarReclamosUsuarios();
}
