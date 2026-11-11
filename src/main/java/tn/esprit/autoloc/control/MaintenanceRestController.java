package tn.esprit.autoloc.control;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.MaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceRestController {

    private final MaintenanceService service;

    @Operation(description = "Recuperer tous les maintenances")
    @GetMapping("/retrieve-all-maintenances")
    public List<Maintenance> retrieveAllMaintenances() {
        return service.retrieveAllMaintenances();
    }

    @Operation(description = "Recuperer Maintenance par son identifiant")
    @GetMapping("/retrieve-maintenance/{id}")
    public Maintenance retrieveMaintenance(@PathVariable("id") Long id) {
        return service.retrieveMaintenance(id);
    }

    @Operation(description = "Ajouter Maintenance")
    @PostMapping("/add-maintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance entity) {
        return service.addMaintenance(entity);
    }

    @Operation(description = "Supprimer Maintenance")
    @DeleteMapping("/remove-maintenance/{id}")
    public void removeMaintenance(@PathVariable("id") Long id) {
        service.removeMaintenance(id);
    }

    @Operation(description = "Modifier Maintenance")
    @PutMapping("/modify-maintenance")
    public Maintenance modifyMaintenance(@RequestBody Maintenance entity) {
        return service.modifyMaintenance(entity);
    }

    @Operation(description = "Affecter Maintenance à un véhicule")
    @PutMapping("/affecter-maintenance-vehicule/{idMaintenance}/{idVehicule}")
    public Maintenance affecterMaintenanceVehicule(@PathVariable("idMaintenance") Long idMaintenance, @PathVariable("idVehicule") Long idVehicule) {
        return service.affecterMaintenanceVehicule(idMaintenance, idVehicule);
    }


}
