package pe.edu.upc.parking_zone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.parking_zone.dtos.EstacionamientoDTO;
import pe.edu.upc.parking_zone.dtos.EstacionamientoEmpresaDTO;
import pe.edu.upc.parking_zone.entities.Estacionamiento;
import pe.edu.upc.parking_zone.servicesinterfaces.IEstacionamientoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estacionamientos")
public class EstacionamientoController {
    @Autowired
    private IEstacionamientoService aS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADEST')")
    public List<Estacionamiento> listar(){
        return aS.list().stream().map(i->{
            ModelMapper m = new ModelMapper();
            return m.map(i,Estacionamiento.class);
        }).collect(Collectors.toList());

    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADEST')")
    public void insertar(@RequestBody EstacionamientoDTO dto){
        ModelMapper m = new ModelMapper();
        Estacionamiento e = m.map(dto, Estacionamiento.class);
        aS.insert(e);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADEST')")
    public EstacionamientoDTO buscarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        EstacionamientoDTO dto = m.map(aS, EstacionamientoDTO.class);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADEST')")
    public void modificar(@RequestBody EstacionamientoDTO dto){
        ModelMapper m = new ModelMapper();
        Estacionamiento e = m.map(dto, Estacionamiento.class);
        aS.update(e);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADEST')")
    public void eliminar(@PathVariable("id") int id){
        aS.delete(id);
    }

    @GetMapping("/empresa-estacionamientos-con-cantidad")
    @PreAuthorize("hasAnyAuthority('ADEST')")
    public ResponseEntity<List<EstacionamientoEmpresaDTO>> getEstacionamientosConCantidad() {
        List<EstacionamientoEmpresaDTO> lista = aS.listarEstacionamientosConCantidadPorEmpresa();
        return ResponseEntity.ok(lista);
    }
}
