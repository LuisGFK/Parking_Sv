package pe.edu.upc.parking_zone.servicesinterfaces;

import pe.edu.upc.parking_zone.entities.Empresa;

import java.util.List;

public interface IEmpresaService {
    public List<Empresa> list();
    public void insert(Empresa e);
    public Empresa listId(int id);
    public void update(Empresa e);
    public void delete(int id);
}
