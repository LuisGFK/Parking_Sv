package pe.edu.upc.parking_zone.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.parking_zone.entities.Reserva;
import pe.edu.upc.parking_zone.repositories.IReservaRepository;
import pe.edu.upc.parking_zone.servicesinterfaces.IReservaService;

import java.util.List;

@Service
public class ReservaServiceImplement implements IReservaService {

    @Autowired
    private IReservaRepository rR;
    @Override
    public List<Reserva> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Reserva reserva) {
        rR.save(reserva);
    }

    @Override
    public Reserva listId(int id) {
        return rR.findById(id).orElse(new Reserva());
    }

    @Override
    public void update(Reserva reserva) {
        rR.save(reserva);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public List<String[]> listarReservasPorUsuario() {
        return rR.listarReservasPorUsuario();
    }

    @Override
    public List<String[]> listarReservasDuplicadas() {
        return rR.listarReservasDuplicadas();
    }

    @Override
    public List<String[]> listarCantidadReservasActivasPorUsuario() {
        return rR.listarCantidadReservasActivasPorUsuario();
    }


}
