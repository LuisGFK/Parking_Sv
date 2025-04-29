package pe.edu.upc.parking_zone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.parking_zone.entities.Pago;

import java.util.List;

@Repository
public interface IPagoRepository extends JpaRepository<Pago, Integer> {

    @Query(value = "SELECT u.username, u.apellido, p.monto_pago, p.fecha_pago, p.estado_pago \n" +
            "FROM pago p \n" +
            "INNER JOIN suscripcion s ON p.id_suscripcion = s.id_suscripcion \n" +
            "INNER JOIN users_table u ON s.user_id = u.id;", nativeQuery = true)
    public List<String[]> listarPagosConUsuarios();

    @Query(value = "SELECT EXTRACT(YEAR FROM p.fecha_pago) AS anio, \n" +
            "       EXTRACT(MONTH FROM p.fecha_pago) AS mes, \n" +
            "       SUM(p.monto_pago) AS total_recaudado, \n" +
            "       COUNT(*) AS cantidad_pagos \n" +
            "FROM pago p \n" +
            "WHERE p.estado_pago = 'CONFIRMADO' \n" +
            "GROUP BY anio, mes \n" +
            "ORDER BY anio, mes;", nativeQuery = true)
    public List<String[]> generarReporteMensualPagos();
}
