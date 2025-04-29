package pe.edu.upc.parking_zone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.parking_zone.dtos.EmpresaDTO;
import pe.edu.upc.parking_zone.entities.Empresa;
import pe.edu.upc.parking_zone.servicesinterfaces.IEmpresaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private IEmpresaService eS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADEST')")
    public List<EmpresaDTO> listar(){

        return eS.list().stream().map(p->{
            ModelMapper m = new ModelMapper();
            return m.map(p, EmpresaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADEST')")
    public void insertar(@RequestBody EmpresaDTO dto) {
        ModelMapper m = new ModelMapper();
        Empresa e = m.map(dto, Empresa.class);
        eS.insert(e);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADEST')")
    public EmpresaDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        EmpresaDTO dto = m.map(eS, EmpresaDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADEST')")
    public void modificar(@RequestBody EmpresaDTO dto) {
        ModelMapper m = new ModelMapper();
        Empresa e = m.map(dto, Empresa.class);
        eS.update(e);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADEST')")
    public void eliminar(@PathVariable("id") int id) {
        eS.delete(id);
    }
}
