package pe.edu.upc.parking_zone.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.parking_zone.entities.Roles;
import pe.edu.upc.parking_zone.repositories.IRolRepository;
import pe.edu.upc.parking_zone.servicesinterfaces.IRolesService;

import java.util.List;

@Service
public class RolesServiceImplements implements IRolesService {
    @Autowired
    private IRolRepository rR;

    @Override
    public List<Roles> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Roles r) {
        rR.save(r);
    }

    @Override
    public Roles listId(Long id) {
        return rR.findById(id).orElse(new Roles());
    }

    @Override
    public void update(Roles r) {
        rR.save(r);
    }

    @Override
    public void delete(Long id) {
        rR.deleteById(id);
    }
}
