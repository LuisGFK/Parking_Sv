package pe.edu.upc.parking_zone.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.parking_zone.dtos.EstacionamientoEmpresaDTO;
import pe.edu.upc.parking_zone.entities.Estacionamiento;
import pe.edu.upc.parking_zone.repositories.IEstacionamientoRepository;
import pe.edu.upc.parking_zone.servicesinterfaces.IEstacionamientoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstacionamientoSeviceImplement implements IEstacionamientoService {

    @Autowired
    private IEstacionamientoRepository uR;

    @Override
    public List<Estacionamiento> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Estacionamiento e) {
        uR.save(e);
    }

    @Override
    public Estacionamiento listId(int id) {
        return uR.findById(id).orElse(new Estacionamiento());
    }

    @Override
    public void update(Estacionamiento e) {
        uR.save(e);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public List<EstacionamientoEmpresaDTO> listarEstacionamientosConCantidadPorEmpresa() {
        List<Object[]> resultados = uR.listarEstacionamientosConCantidadPorEmpresa();
        List<EstacionamientoEmpresaDTO> listaDTO = new ArrayList<>();

        for (Object[] fila : resultados) {
            EstacionamientoEmpresaDTO dto = new EstacionamientoEmpresaDTO(
                    (String) fila[0],
                    (String) fila[1],
                    (String) fila[2],
                    ((Number) fila[3]).doubleValue(),
                    ((Number) fila[4]).intValue()
            );
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}

