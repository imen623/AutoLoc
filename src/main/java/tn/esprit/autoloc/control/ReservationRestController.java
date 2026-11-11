package tn.esprit.autoloc.control;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.ReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    private final ReservationService service;

    @Operation(description = "Recuperer tous les reservations")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> retrieveAllReservations() {
        return service.retrieveAllReservations();
    }

    @Operation(description = "Recuperer Reservation par son identifiant")
    @GetMapping("/retrieve-reservation/{id}")
    public Reservation retrieveReservation(@PathVariable("id") Long id) {
        return service.retrieveReservation(id);
    }

    @Operation(description = "Ajouter Reservation")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation entity) {
        return service.addReservation(entity);
    }

    @Operation(description = "Supprimer Reservation")
    @DeleteMapping("/remove-reservation/{id}")
    public void removeReservation(@PathVariable("id") Long id) {
        service.removeReservation(id);
    }

    @Operation(description = "Modifier Reservation")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation entity) {
        return service.modifyReservation(entity);
    }

    @Operation(description = "Ajouter Reservation avec contrat")
    @PostMapping("/add-reservation-contrat")
    public Reservation ajouterContratReservation(@RequestBody Reservation r) {
        return service.ajouterContratReservation(r);
    }

}
