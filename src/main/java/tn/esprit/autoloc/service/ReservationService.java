package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import java.util.List;

public interface ReservationService {

    List<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(Long id);
    Reservation addReservation(Reservation entity);
    void removeReservation(Long id);
    Reservation modifyReservation(Reservation entity);
    Reservation ajouterContratReservation(Reservation r);
}
