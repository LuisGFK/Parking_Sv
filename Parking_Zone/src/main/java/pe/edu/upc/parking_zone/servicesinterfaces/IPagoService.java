package pe.edu.upc.parking_zone.servicesinterfaces;


import pe.edu.upc.parking_zone.entities.Pago;

import java.util.List;

public interface IPagoService {
    public List<Pago> list();
    public void insert(Pago pg);
    public Pago listId(int id);
    public void update(Pago pg);
    public void delete(int id);
    public List<String[]> listarPagosConUsuarios();
    public List<String[]> generarReporteMensualPagos();
}
