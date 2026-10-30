package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return repository.findAll();
    }

    @Override
    public Reservation retrieveReservation(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Reservation addReservation(Reservation entity) {
        return repository.save(entity);
    }

    @Override
    public void removeReservation(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Reservation modifyReservation(Reservation entity) {
        return repository.save(entity);
    }
}
