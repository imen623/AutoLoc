package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.Client;
import java.util.List;

public interface ClientService {

    List<Client> retrieveAllClients();
    Client retrieveClient(Long id);
    Client addClient(Client entity);
    void removeClient(Long id);
    Client modifyClient(Client entity);
    Client ajouterClierntReservation(Client c);
    List<Client> recupererPrenomNomEtCategorieVehicule(String n, String p, CategorieVehicule cv);
}
