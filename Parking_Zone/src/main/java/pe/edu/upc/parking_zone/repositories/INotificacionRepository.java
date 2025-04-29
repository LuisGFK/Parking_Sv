package pe.edu.upc.parking_zone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.parking_zone.entities.Notificacion;

import java.util.List;

@Repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {

    @Query(value = "SELECT u.username, u.apellido, n.mensaje, n.estado, n.fecha_emision, n.fecha_programada \n" +
            "FROM notificacion n \n" +
            "INNER JOIN users_table u ON n.user_id = u.id;", nativeQuery = true)
    public List<String[]> listarHistorialNotificaciones();
}
