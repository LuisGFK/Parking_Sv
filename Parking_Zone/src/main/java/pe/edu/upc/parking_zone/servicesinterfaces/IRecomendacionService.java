package pe.edu.upc.parking_zone.servicesinterfaces;

import pe.edu.upc.parking_zone.entities.Recomendacion;

import java.util.List;

public interface IRecomendacionService {
    public List<Recomendacion> list();
    public void insert(Recomendacion rr);
    public Recomendacion listId(int id);
    public void update(Recomendacion rr);
    public void delete(int id);
}
