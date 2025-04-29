package pe.edu.upc.parking_zone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.parking_zone.dtos.RolesDTO;
import pe.edu.upc.parking_zone.entities.Roles;
import pe.edu.upc.parking_zone.servicesinterfaces.IRolesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private IRolesService rS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public List<RolesDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RolesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void insertar(@RequestBody RolesDTO dto){
        ModelMapper m = new ModelMapper();
        Roles r = m.map(dto,Roles.class);
        rS.insert(r);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public RolesDTO buscarId(@PathVariable("id") Long id){
        ModelMapper m = new ModelMapper();
        RolesDTO dto = m.map(rS.listId(id), RolesDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void modificar(@RequestBody RolesDTO dto){
        ModelMapper m = new ModelMapper();
        Roles r = m.map(dto,Roles.class);
        rS.update(r);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void eliminar(@PathVariable("id") Long id){
        rS.delete(id);
    }
}
