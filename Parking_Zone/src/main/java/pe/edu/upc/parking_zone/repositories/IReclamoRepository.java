package pe.edu.upc.parking_zone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.parking_zone.entities.Reclamo;

import java.util.List;

@Repository
public interface IReclamoRepository extends JpaRepository<Reclamo, Integer> {

    @Query(value ="SELECT u.username, u.apellido, r.titulo, r.descripcion, r.estado, r.fecha, r.hora \n" +
            "FROM reclamo r \n" +
            "INNER JOIN users_table u ON r.user_id = u.id;", nativeQuery = true)
    public List<String[]> listarReclamosUsuarios();

}
