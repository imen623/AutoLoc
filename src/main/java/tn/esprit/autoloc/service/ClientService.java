package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import java.util.List;

public interface ClientService {

    List<Client> retrieveAllClients();
    Client retrieveClient(Long id);
    Client addClient(Client entity);
    void removeClient(Long id);
    Client modifyClient(Client entity);
}
