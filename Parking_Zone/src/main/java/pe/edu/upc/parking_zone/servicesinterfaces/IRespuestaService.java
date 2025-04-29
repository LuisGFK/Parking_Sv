package pe.edu.upc.parking_zone.servicesinterfaces;

import pe.edu.upc.parking_zone.entities.Respuesta;

import java.util.List;

public interface IRespuestaService {
    public List<Respuesta> list();
    public void insert(Respuesta ra);
    public Respuesta listId(int id);
    public void update(Respuesta ra);
    public void delete(int id);
    public List<String[]> listarRespuestasReclamos();
}
