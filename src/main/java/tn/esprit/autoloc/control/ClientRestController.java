package tn.esprit.autoloc.control;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.ClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientRestController {

    private final ClientService service;

    @Operation(description = "Recuperer tous les clients")
    @GetMapping("/retrieve-all-clients")
    public List<Client> retrieveAllClients() {
        return service.retrieveAllClients();
    }

    @Operation(description = "Recuperer Client par son identifiant")
    @GetMapping("/retrieve-client/{id}")
    public Client retrieveClient(@PathVariable("id") Long id) {
        return service.retrieveClient(id);
    }

    @Operation(description = "Ajouter Client")
    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client entity) {
        return service.addClient(entity);
    }

    @Operation(description = "Supprimer Client")
    @DeleteMapping("/remove-client/{id}")
    public void removeClient(@PathVariable("id") Long id) {
        service.removeClient(id);
    }

    @Operation(description = "Modifier Client")
    @PutMapping("/modify-client")
    public Client modifyClient(@RequestBody Client entity) {
        return service.modifyClient(entity);
    }

    @Operation(description = "Ajouter Client avec ses reservations")
    @PostMapping("/add-client-reservations")
    public Client ajouterClierntReservation(@RequestBody Client c) {
        return service.ajouterClierntReservation(c);
    }


    @Operation(description = "Recuperer Client par son nom, prenom et categorie vehicule")
    @GetMapping("/retrieve-client-by-nom-prenom-categorie/{n}/{p}/{cv}")
    public List<Client> recupererPrenomNomEtCategorieVehicule(@PathVariable String n,@PathVariable String p,@PathVariable CategorieVehicule cv) {
        return service.recupererPrenomNomEtCategorieVehicule(n, p, cv);
    }
}
