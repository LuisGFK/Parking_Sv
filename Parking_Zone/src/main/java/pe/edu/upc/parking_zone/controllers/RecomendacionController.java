package pe.edu.upc.parking_zone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.parking_zone.dtos.RecomendacionDTO;
import pe.edu.upc.parking_zone.entities.Recomendacion;
import pe.edu.upc.parking_zone.servicesinterfaces.IRecomendacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionController {
    @Autowired
    private IRecomendacionService cS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADM','ADEST')")
    public List<Recomendacion> list(){
        return cS.list().stream().map(o->{
            ModelMapper m = new ModelMapper();
            return m.map(o,Recomendacion.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADM','ADEST')")
    public void insertar(@RequestBody RecomendacionDTO dto){
        ModelMapper m = new ModelMapper();
        Recomendacion rr = m.map(dto, Recomendacion.class);
        cS.insert(rr);

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADM','ADEST')")
    public RecomendacionDTO buscarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        RecomendacionDTO dto = m.map(cS, RecomendacionDTO.class);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADM','ADEST')")
    public void modificar(@RequestBody RecomendacionDTO dto){
        ModelMapper m = new ModelMapper();
        Recomendacion rr = m.map(dto, Recomendacion.class);
        cS.update(rr);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADM','ADEST')")
    public void eliminar(@PathVariable("id") int id){
        cS.delete(id);
    }
}
