package pe.edu.upc.parking_zone.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.parking_zone.entities.Reclamo;
import pe.edu.upc.parking_zone.repositories.IReclamoRepository;
import pe.edu.upc.parking_zone.servicesinterfaces.IReclamoService;

import java.util.List;

@Service
public class ReclamoServiceImplement implements IReclamoService {
    @Autowired
    private IReclamoRepository mR;

    @Override
    public List<Reclamo> list() {
        return mR.findAll();
    }

    @Override
    public void insert(Reclamo rm) {
        mR.save(rm);
    }

    @Override
    public Reclamo listId(int id) {
        return mR.findById(id).orElse(new Reclamo());
    }

    @Override
    public void update(Reclamo rm) {
        mR.save(rm);
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public List<String[]> listarReclamosUsuarios() {
        return mR.listarReclamosUsuarios();
    }
}
