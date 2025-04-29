package pe.edu.upc.parking_zone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.parking_zone.dtos.ReservaDTO;
import pe.edu.upc.parking_zone.dtos.ReservaDuplicadaDTO;
import pe.edu.upc.parking_zone.dtos.ReservaUsuarioDTO;
import pe.edu.upc.parking_zone.dtos.ReservasActivasUsuarioDTO;
import pe.edu.upc.parking_zone.entities.Reserva;
import pe.edu.upc.parking_zone.servicesinterfaces.IReservaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private IReservaService rS;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public List<ReservaDTO> listar(){
        return rS.list().stream().map( v->{
            ModelMapper m = new ModelMapper();
            return m.map(v, ReservaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void insertar(@RequestBody ReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reserva reserva = m.map(dto, Reserva.class);
        rS.insert(reserva);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public ReservaDTO buscarId(@PathVariable("id")int id) {
        ModelMapper m = new ModelMapper();
        ReservaDTO dto = m.map(rS, ReservaDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void modificar(@RequestBody ReservaDTO dto) {
        ModelMapper m = new ModelMapper();
        Reserva reserva = m.map(dto, Reserva.class);
        rS.update(reserva);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void eliminar(@PathVariable("id")int id) {
        rS.delete(id);
    }

    @GetMapping("/historialusers")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public List<ReservaUsuarioDTO> historial(){
        List<String[]> fila =rS.listarReservasPorUsuario();
        List<ReservaUsuarioDTO> dtoLista = new ArrayList<>();

        for(String[] columna : fila){
            ReservaUsuarioDTO dto = new ReservaUsuarioDTO();
            dto.setUsername(columna[0]);
            dto.setApellido(columna[1]);
            dto.setFechaReserva(LocalDate.parse(columna[2]));
            dto.setEstadoReserva(columna[3]);
            dtoLista.add(dto);
        }

        return dtoLista;
    }

    @GetMapping("/reservas-duplicadas")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public List<ReservaDuplicadaDTO> reservasDuplicadas(){
        List<String[]> fila =rS.listarReservasDuplicadas();
        List<ReservaDuplicadaDTO> dtoLista = new ArrayList<>();

        for(String[] columna : fila){
            ReservaDuplicadaDTO dto = new ReservaDuplicadaDTO();
            dto.setUsername(columna[0]);
            dto.setApellido(columna[1]);
            dto.setNombre(columna[2]);
            dto.setFechaReserva(LocalDate.parse(columna[3]));
            dto.setCantidadReservas(Integer.parseInt(columna[4]));
        }
        return dtoLista;
    }

    @GetMapping("/reservas-activas-usuario")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public List<ReservasActivasUsuarioDTO> reservasActivasUsuario(){
        List<String[]> fila =rS.listarCantidadReservasActivasPorUsuario();
        List<ReservasActivasUsuarioDTO> dtoLista = new ArrayList<>();

        for(String[] columna : fila){
            ReservasActivasUsuarioDTO dto = new ReservasActivasUsuarioDTO();
            dto.setUsername(columna[0]);
            dto.setApellido(columna[1]);
            dto.setCantidadReservasActivas(Integer.parseInt(columna[2]));
        }
        return dtoLista;
    }
}
