package tn.esprit.autoloc.control;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.AgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceRestController {

    private final AgenceService service;

    @Operation(description = "Recuperer tous les agences")
    @GetMapping("/retrieve-all-agences")
    public List<Agence> retrieveAllAgences() {
        return service.retrieveAllAgences();
    }

    @Operation(description = "Recuperer Agence par son identifiant")
    @GetMapping("/retrieve-agence/{id}")
    public Agence retrieveAgence(@PathVariable("id") Long id) {
        return service.retrieveAgence(id);
    }

    @Operation(description = "Ajouter Agence")
    @PostMapping("/add-agence")
    public Agence addAgence(@RequestBody Agence entity) {
        return service.addAgence(entity);
    }

    @Operation(description = "Supprimer Agence")
    @DeleteMapping("/remove-agence/{id}")
    public void removeAgence(@PathVariable("id") Long id) {
        service.removeAgence(id);
    }

    @Operation(description = "Modifier Agence")
    @PutMapping("/modify-agence")
    public Agence modifyAgence(@RequestBody Agence entity) {
        return service.modifyAgence(entity);
    }
}
