package pe.edu.upc.parking_zone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.parking_zone.dtos.NotificacionReservaDTO;
import pe.edu.upc.parking_zone.entities.NotificacionReserva;
import pe.edu.upc.parking_zone.servicesinterfaces.INotificacionReservaService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/notificacionesreservadas")
public class NotificacionReservaController {

    @Autowired
    private INotificacionReservaService nS;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public List<NotificacionReservaDTO> listar(){
        return nS.list().stream().map(n->{
            ModelMapper m = new ModelMapper();
            return m.map(n, NotificacionReservaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void insertar(@RequestBody NotificacionReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        NotificacionReserva notificacionReserva = m.map(dto, NotificacionReserva.class);
        nS.insert(notificacionReserva);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public NotificacionReservaDTO buscarId(@PathVariable("id")int id ){
        ModelMapper m = new ModelMapper();
        NotificacionReservaDTO dto = m.map(nS, NotificacionReservaDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void modificar(@RequestBody NotificacionReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        NotificacionReserva notificacionReserva = m.map(dto, NotificacionReserva.class);
        nS.update(notificacionReserva);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void eliminar(@PathVariable("id")int id) {
        nS.delete(id);
    }
}
