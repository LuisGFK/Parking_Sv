package pe.edu.upc.parking_zone.servicesinterfaces;



import pe.edu.upc.parking_zone.entities.TipoNotificacion;

import java.util.List;

public interface ITipoNotificacionService {
    public List<TipoNotificacion> list();
    public void insert(TipoNotificacion tp);
    public TipoNotificacion listId(int id);
    public void update(TipoNotificacion tp);
    public void delete(int id);
    public List<TipoNotificacion> buscar(String Descripcion);
}
