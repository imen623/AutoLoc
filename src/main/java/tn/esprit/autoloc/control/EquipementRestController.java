package tn.esprit.autoloc.control;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.EquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
public class EquipementRestController {

    private final EquipementService service;

    @Operation(description = "Recuperer tous les equipements")
    @GetMapping("/retrieve-all-equipements")
    public List<Equipement> retrieveAllEquipements() {
        return service.retrieveAllEquipements();
    }

    @Operation(description = "Recuperer Equipement par son identifiant")
    @GetMapping("/retrieve-equipement/{id}")
    public Equipement retrieveEquipement(@PathVariable("id") Long id) {
        return service.retrieveEquipement(id);
    }

    @Operation(description = "Ajouter Equipement")
    @PostMapping("/add-equipement")
    public Equipement addEquipement(@RequestBody Equipement entity) {
        return service.addEquipement(entity);
    }

    @Operation(description = "Supprimer Equipement")
    @DeleteMapping("/remove-equipement/{id}")
    public void removeEquipement(@PathVariable("id") Long id) {
        service.removeEquipement(id);
    }

    @Operation(description = "Modifier Equipement")
    @PutMapping("/modify-equipement")
    public Equipement modifyEquipement(@RequestBody Equipement entity) {
        return service.modifyEquipement(entity);
    }


}

