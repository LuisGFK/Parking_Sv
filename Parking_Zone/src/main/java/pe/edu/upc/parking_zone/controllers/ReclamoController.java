package pe.edu.upc.parking_zone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.parking_zone.dtos.ReclamoDTO;
import pe.edu.upc.parking_zone.dtos.ReclamoUsuarioDTO;
import pe.edu.upc.parking_zone.entities.Reclamo;
import pe.edu.upc.parking_zone.servicesinterfaces.IReclamoService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {
    @Autowired
    private IReclamoService mS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public List<ReclamoDTO> list(){
        return mS.list().stream().map(l->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(l, ReclamoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public void insertar(@RequestBody ReclamoDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        Reclamo rc=modelMapper.map(dto, Reclamo.class);
        mS.insert(rc);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public ReclamoDTO buscarId(@PathVariable("id") int id){
        ModelMapper modelMapper = new ModelMapper();
        ReclamoDTO dto = modelMapper.map(mS, ReclamoDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public void modificar(@RequestBody ReclamoDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        Reclamo rc=modelMapper.map(dto, Reclamo.class);
        mS.update(rc);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public void eliminar(@PathVariable("id") int id){
        mS.delete(id);
    }

    @GetMapping("/reclamos-usuarios")
    @PreAuthorize("hasAnyAuthority('ADRCL')")
    public List<ReclamoUsuarioDTO> reclamos(){
        List<String[]> fila = mS.listarReclamosUsuarios();
        List<ReclamoUsuarioDTO>  dtoLista = new ArrayList<>();

        for(String[] columna:fila){
            ReclamoUsuarioDTO dto = new ReclamoUsuarioDTO();
            dto.setUsername(columna[0]);
            dto.setApellido(columna[1]);
            dto.setTitulo(columna[2]);
            dto.setDescripcion(columna[3]);
            dto.setEstado(columna[4]);
            dto.setFecha(LocalDate.parse(columna[5]));
            dto.setHora(LocalTime.parse(columna[6]));
        }
        return dtoLista;
    }
}
