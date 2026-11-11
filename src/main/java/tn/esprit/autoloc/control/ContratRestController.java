package tn.esprit.autoloc.control;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.ContratService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratRestController {

    private final ContratService service;

    @Operation(description = "Recuperer tous les contrats")
    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> retrieveAllContrats() {
        return service.retrieveAllContrats();
    }

    @Operation(description = "Recuperer Contrat par son identifiant")
    @GetMapping("/retrieve-contrat/{id}")
    public Contrat retrieveContrat(@PathVariable("id") Long id) {
        return service.retrieveContrat(id);
    }

    @Operation(description = "Ajouter Contrat")
    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody Contrat entity) {
        return service.addContrat(entity);
    }

    @Operation(description = "Supprimer Contrat")
    @DeleteMapping("/remove-contrat/{id}")
    public void removeContrat(@PathVariable("id") Long id) {
        service.removeContrat(id);
    }

    @Operation(description = "Modifier Contrat")
    @PutMapping("/modify-contrat")
    public Contrat modifyContrat(@RequestBody Contrat entity) {
        return service.modifyContrat(entity);
    }
}
