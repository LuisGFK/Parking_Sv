package pe.edu.upc.parking_zone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.parking_zone.dtos.UsersDTO;
import pe.edu.upc.parking_zone.entities.Users;
import pe.edu.upc.parking_zone.servicesinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/usuarios")
public class UsersController {
    @Autowired
    private IUsersService uS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public List<UsersDTO> listar(){
        return uS.list().stream().map(o->{
            ModelMapper m = new ModelMapper();
            return m.map(o, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void insertar(@RequestBody UsersDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        uS.insert(u);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public UsersDTO buscarId(@PathVariable("id")long id){
        ModelMapper m = new ModelMapper();
        UsersDTO dto = m.map(uS, UsersDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void modificar(@RequestBody UsersDTO dto){
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        uS.update(u);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public void eliminar(@PathVariable("id")long id){
        uS.delete(id);
    }

    @GetMapping("/busquedas")
    @PreAuthorize("hasAnyAuthority('ADM')")
    public List<UsersDTO>buscarNombre(@RequestParam(required = false)String username){
        return uS.buscar(username).stream().map(h->{
            ModelMapper m = new ModelMapper();
            return m.map(h, UsersDTO.class);
        }).collect(Collectors.toList());
    }
}
