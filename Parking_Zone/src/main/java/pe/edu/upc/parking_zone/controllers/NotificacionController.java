package pe.edu.upc.parking_zone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.parking_zone.dtos.NotificacionDTO;
import pe.edu.upc.parking_zone.dtos.NotificacionUsuarioDTO;
import pe.edu.upc.parking_zone.entities.Notificacion;
import pe.edu.upc.parking_zone.servicesinterfaces.INotificacionService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
    @Autowired
    private INotificacionService nS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADNF')")
    public List<NotificacionDTO> Listar(){
        return nS.list().stream().map(t->{
            ModelMapper m = new ModelMapper();
            return m.map(t, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADNF')")
    public void insertar(@RequestBody NotificacionDTO dto){
        ModelMapper m = new ModelMapper();
        Notificacion n= m.map(dto, Notificacion.class);
        nS.insert(n);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADNF')")
    public NotificacionDTO buscarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto = m.map(nS, NotificacionDTO.class);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADNF')")
    public void modificar(@RequestBody NotificacionDTO dto){
        ModelMapper m = new ModelMapper();
        Notificacion n= m.map(dto, Notificacion.class);
        nS.update(n);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADNF')")
    public void eliminar(@PathVariable("id") int id){
        nS.delete(id);
    }

    @GetMapping("/historial-notificaciones-users")
    @PreAuthorize("hasAnyAuthority('ADNF')")
    public List<NotificacionUsuarioDTO> notificacionesUsuarios(){
        List<String[]> fila =nS.listarHistorialNotificaciones();
        List<NotificacionUsuarioDTO> dtoLista = new ArrayList<>();

        for (String[] columna : fila) {
            NotificacionUsuarioDTO dto = new NotificacionUsuarioDTO();
            dto.setUsername(columna[0]);
            dto.setApellido(columna[1]);
            dto.setMensaje(columna[2]);
            dto.setEstado(columna[3]);
            dto.setFechaEmision(LocalDate.parse(columna[4]));
            dto.setFechaProgramada(LocalDate.parse(columna[5]));
        }
        return dtoLista;
    }

}
