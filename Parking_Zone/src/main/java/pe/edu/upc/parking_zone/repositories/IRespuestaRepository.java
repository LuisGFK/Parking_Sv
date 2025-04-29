package pe.edu.upc.parking_zone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.parking_zone.entities.Respuesta;

import java.util.List;

@Repository
public interface IRespuestaRepository extends JpaRepository<Respuesta, Integer> {

    @Query(value = "SELECT r.titulo, res.fecha, res.hora \n" +
            "FROM respuesta res \n" +
            "INNER JOIN reclamo r ON res.id_reclamo = r.id_reclamo;", nativeQuery = true)
    public List<String[]> listarRespuestasReclamos();
}
