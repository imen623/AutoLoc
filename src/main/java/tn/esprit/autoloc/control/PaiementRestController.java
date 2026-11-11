package tn.esprit.autoloc.control;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.PaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
public class PaiementRestController {

    private final PaiementService service;

    @Operation(description = "Recuperer tous les paiements")
    @GetMapping("/retrieve-all-paiements")
    public List<Paiement> retrieveAllPaiements() {
        return service.retrieveAllPaiements();
    }

    @Operation(description = "Recuperer Paiement par son identifiant")
    @GetMapping("/retrieve-paiement/{id}")
    public Paiement retrievePaiement(@PathVariable("id") Long id) {
        return service.retrievePaiement(id);
    }

    @Operation(description = "Ajouter Paiement")
    @PostMapping("/add-paiement")
    public Paiement addPaiement(@RequestBody Paiement entity) {
        return service.addPaiement(entity);
    }

    @Operation(description = "Supprimer Paiement")
    @DeleteMapping("/remove-paiement/{id}")
    public void removePaiement(@PathVariable("id") Long id) {
        service.removePaiement(id);
    }

    @Operation(description = "Modifier Paiement")
    @PutMapping("/modify-paiement")
    public Paiement modifyPaiement(@RequestBody Paiement entity) {
        return service.modifyPaiement(entity);
    }
}
