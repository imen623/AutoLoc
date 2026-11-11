package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepo;
    private final ReservationRepository reservationRepository;

    @Override
    public List<Client> retrieveAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepo.findById(id).get();
    }

    @Override
    public Client addClient(Client entity) {
        return clientRepo.save(entity);
    }

    @Override
    public void removeClient(Long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Client modifyClient(Client entity) {
        return clientRepo.save(entity);
    }

    @Override
    public Client ajouterClierntReservation(Client c) {
        clientRepo.save(c);
        for (Reservation r : c.getReservations()) {
            r.setClient(c);
            reservationRepository.save(r);
        }
        return c;
    }

    @Override
    public List<Client> recupererPrenomNomEtCategorieVehicule(String n, String p, CategorieVehicule cv) {

        return clientRepo.findByNomAndPrenomAndReservationsVehiculeCategorie(n, p, cv);

    }
}
