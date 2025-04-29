package pe.edu.upc.parking_zone.controllers;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.parking_zone.dtos.PagoDTO;
import pe.edu.upc.parking_zone.dtos.PagoUsuarioDTO;
import pe.edu.upc.parking_zone.dtos.ReporteMensualPagoDTO;
import pe.edu.upc.parking_zone.entities.Pago;
import pe.edu.upc.parking_zone.servicesinterfaces.IPagoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private static final Logger logger = LoggerFactory.getLogger(PagoController.class);

    @Autowired
    private IPagoService gS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADSUB')")
    public List<PagoDTO> list() {
        logger.info("Obteniendo lista de pagos...");

        List<PagoDTO> pagos = gS.list().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, PagoDTO.class);
        }).collect(Collectors.toList());

        logger.info("Total pagos recuperados: {}", pagos.size());
        return pagos;
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADSUB')")
    public void insertar(@RequestBody PagoDTO dto) {
        logger.info("Insertando pago...");

        ModelMapper m = new ModelMapper();
        Pago pg = m.map(dto, Pago.class);

        gS.insert(pg);
        logger.info("Pago insertado correctamente.");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADSUB')")
    public PagoDTO buscarId(@PathVariable("id") int id) {
        logger.info("Buscando pago con ID: {}", id);

        ModelMapper m = new ModelMapper();
        PagoDTO dto = m.map(gS.listId(id), PagoDTO.class);

        logger.info("Pago encontrado: {}", dto);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADSUB')")
    public void modificar(@RequestBody PagoDTO dto) {
        logger.info("Modificando pago...");

        ModelMapper m = new ModelMapper();
        Pago pg = m.map(dto, Pago.class);

        gS.update(pg);
        logger.info("Pago modificado correctamente.");
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADSUB')")
    public void eliminar(@PathVariable("id") int id) {
        try {
            logger.info("Eliminando pago con ID: {}", id);
            gS.delete(id);
            logger.info("Pago eliminado correctamente.");
        } catch (Exception e) {
            logger.error("Error al eliminar pago con ID {}: {}", id, e.getMessage());
        }
    }

    @GetMapping("/pagos-usuarios")
    @PreAuthorize("hasAnyAuthority('ADSUB')")
    public List<PagoUsuarioDTO> pagosUsuarios() {
        logger.info("Obteniendo pagos de usuarios...");

        List<String[]> fila = gS.listarPagosConUsuarios();
        logger.info("Total pagos recuperados: {}", fila.size());

        List<PagoUsuarioDTO> dtoLista = new ArrayList<>();
        for (String[] columna : fila) {
            PagoUsuarioDTO dto = new PagoUsuarioDTO();
            dto.setUsername(columna[0]);
            dto.setApellido(columna[1]);
            dto.setMontoPago(Double.parseDouble(columna[2]));
            dto.setFechaPago(LocalDate.parse(columna[3]));
            dto.setEstadoPago(columna[4]);
            dtoLista.add(dto);
        }

        logger.info("Lista de pagos de usuarios generada correctamente con {} elementos.", dtoLista.size());
        return dtoLista;
    }

    @GetMapping("/reporte-mensual-pagos")
    @PreAuthorize("hasAnyAuthority('ADSUB')")
    public List<ReporteMensualPagoDTO> mensualPagos() {
        logger.info("Generando reporte mensual de pagos...");

        List<String[]> fila = gS.listarPagosConUsuarios();
        logger.info("Total registros en reporte: {}", fila.size());

        List<ReporteMensualPagoDTO> dtoLista = new ArrayList<>();
        for (String[] columna : fila) {
            ReporteMensualPagoDTO dto = new ReporteMensualPagoDTO();
            dto.setAnio(Integer.parseInt(columna[0]));
            dto.setMes(Integer.parseInt(columna[1]));
            dto.setTotalRecaudado(Double.parseDouble(columna[2]));
            dto.setCantidadPagos(Integer.parseInt(columna[3]));
            dtoLista.add(dto);
        }

        logger.info("Reporte mensual generado correctamente con {} registros.", dtoLista.size());
        return dtoLista;
    }
}
