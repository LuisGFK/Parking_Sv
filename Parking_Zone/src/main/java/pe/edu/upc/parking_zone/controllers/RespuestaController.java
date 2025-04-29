package pe.edu.upc.parking_zone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.parking_zone.dtos.RespuestaDTO;
import pe.edu.upc.parking_zone.dtos.RespuestaReclamoDTO;
import pe.edu.upc.parking_zone.entities.Respuesta;
import pe.edu.upc.parking_zone.servicesinterfaces.IRespuestaService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
    @Autowired
    private IRespuestaService eS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public List<RespuestaDTO> list(){
        return eS.list().stream().map(w->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(w,RespuestaDTO.class);
        }).collect(Collectors.toList());

    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public void insertar(@RequestBody RespuestaDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        Respuesta ra = modelMapper.map(dto,Respuesta.class);
        eS.insert(ra);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public RespuestaDTO buscarId(@PathVariable("id") int id){
        ModelMapper modelMapper = new ModelMapper();
        RespuestaDTO dto = modelMapper.map(eS, RespuestaDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public void modificar(@RequestBody RespuestaDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        Respuesta ra = modelMapper.map(dto,Respuesta.class);
        eS.update(ra);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public void eliminar(@PathVariable("id") int id){
        eS.delete(id);
    }

    @GetMapping("/respuestasreclamos")
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public List<RespuestaReclamoDTO> respuestasReclamos(){
        List<String[]> fila = eS.listarRespuestasReclamos();
        List<RespuestaReclamoDTO> dtoLista = new ArrayList<>();

        for(String[] columna : fila){
            RespuestaReclamoDTO dto = new RespuestaReclamoDTO();
            dto.setTitulo(columna[0]);
            dto.setFecha(LocalDate.parse(columna[1]));
            dto.setHora(LocalTime.parse(columna[2]));
        }
        return dtoLista;
    }
}
