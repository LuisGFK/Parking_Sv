package pe.edu.upc.parking_zone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.parking_zone.entities.Estacionamiento;

import java.util.List;

@Repository
public interface IEstacionamientoRepository extends JpaRepository<Estacionamiento, Integer> {


    @Query(value = "SELECT e.nombre_empresa, es.nombre, es.direccion, es.tarifa_hora, " +
            "(SELECT COUNT(*) FROM estacionamiento sub WHERE sub.id_empresa = e.id_empresa) " +
            "AS cantidad_estacionamientos " +
            "FROM estacionamiento es " +
            "INNER JOIN empresa e ON es.id_empresa = e.id_empresa", nativeQuery = true)
    List<Object[]> listarEstacionamientosConCantidadPorEmpresa();
}
