package tn.esprit.autoloc.control;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.VehiculeService;
import java.util.List;

@Tag(name = "Autoloc API - Vehicule Management")



@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")

public class VehiculeRestController {
    VehiculeService vehiculeService;

    @Operation(description = "récupérer toutes les véhicules de la base de données")
    // http://localhost:8089/autoloc/vehicule/retrieve-all-vehicules
    @GetMapping("/retrieve-all-vehicules")
    public List<Vehicule> getVehicules() {
    List<Vehicule> listVehicules = vehiculeService.retrieveAllVehicules();  return listVehicules;
    }

    @Operation(description = "récupérer un véhicule par son ID")
    // http://localhost:8089/autoloc-api/vehicule/retrieve-vehicule/8
    @GetMapping("/retrieve-vehicule/{vehicule-id}")
    public Vehicule retrieveVehicule(@PathVariable("vehicule-id") Long vehiculeId) {  Vehicule vehicule = vehiculeService.retrieveVehicule(vehiculeId);
    return vehicule;
    }

    @Operation(description = "ajouter un véhicule")
    // http://localhost:8089/autoloc-api/vehicule/add-vehicule
    @PostMapping("/add-vehicule")
    public Vehicule addVehicule(@RequestBody Vehicule c) {  Vehicule vehicule = vehiculeService.addVehicule(c);  return vehicule;
    }

    @Operation(description = "supprimer un véhicule")
    // http://localhost:8089/autoloc-api/vehicule/remove-vehicule/{vehicule-id}
    @DeleteMapping("/remove-vehicule/{vehicule-id}")
    public void removeVehicule(@PathVariable("vehicule-id") Long vehiculeId) {  vehiculeService.removeVehicule(vehiculeId);
    }

    @Operation(description = "modifier un véhicule")
    // http://localhost:8089/autoloc-api/vehicule/modify-vehicule/
    @PutMapping("/modify-vehicule")
    public Vehicule modifyVehicule(@RequestBody Vehicule c) {  Vehicule vehicule = vehiculeService.modifyVehicule(c);  return vehicule;
    }

}

