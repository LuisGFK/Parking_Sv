package pe.edu.upc.parking_zone.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.parking_zone.entities.Suscripcion;
import pe.edu.upc.parking_zone.repositories.ISuscripcionRepository;
import pe.edu.upc.parking_zone.servicesinterfaces.ISuscripcionService;

import java.util.List;

@Service
public class SuscripcionServiceImplement implements ISuscripcionService {
    @Autowired
    private ISuscripcionRepository pR;
    @Override
    public List<Suscripcion> list() {
        return pR.findAll();
    }

    @Override
    public void insert(Suscripcion sp) {
        pR.save(sp);
    }

    @Override
    public Suscripcion ListId(int id) {
        return pR.findById(id).orElse(new Suscripcion());
    }

    @Override
    public void update(Suscripcion sp) {
        pR.save(sp);
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }
}
