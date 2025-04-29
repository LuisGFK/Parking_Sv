package pe.edu.upc.parking_zone.servicesinterfaces;

import pe.edu.upc.parking_zone.entities.Reserva;

import java.util.List;

public interface IReservaService {

    public List<Reserva> list();
    public void insert(Reserva reserva);
    public Reserva listId(int id);
    public void update(Reserva reserva);
    public void delete(int id);
    public List<String[]> listarReservasPorUsuario();
    public List<String[]> listarReservasDuplicadas();
    public List<String[]> listarCantidadReservasActivasPorUsuario();
}
