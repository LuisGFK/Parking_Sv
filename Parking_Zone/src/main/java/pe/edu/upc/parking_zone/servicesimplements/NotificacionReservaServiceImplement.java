package pe.edu.upc.parking_zone.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.parking_zone.entities.NotificacionReserva;
import pe.edu.upc.parking_zone.repositories.INotificacionReservaRepository;
import pe.edu.upc.parking_zone.servicesinterfaces.INotificacionReservaService;

import java.util.List;
@Service
public class NotificacionReservaServiceImplement implements INotificacionReservaService {

    @Autowired
    private INotificacionReservaRepository nR;

    @Override
    public List<NotificacionReserva> list() {
        return nR.findAll();
    }

    @Override
    public void insert(NotificacionReserva notificacionReserva) {
        nR.save(notificacionReserva);
    }

    @Override
    public NotificacionReserva listId(int id) {
        return nR.findById(id).orElse(new NotificacionReserva());
    }

    @Override
    public void update(NotificacionReserva notificacionReserva) {
        nR.save(notificacionReserva);
    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);
    }
}
