package pe.edu.upc.parking_zone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.parking_zone.entities.Suscripcion;


@Repository
public interface ISuscripcionRepository extends JpaRepository<Suscripcion, Integer> {
}
