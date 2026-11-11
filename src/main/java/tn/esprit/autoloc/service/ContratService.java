package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Contrat;
import java.util.List;

public interface ContratService {

    List<Contrat> retrieveAllContrats();
    Contrat retrieveContrat(Long id);
    Contrat addContrat(Contrat entity);
    void removeContrat(Long id);
    Contrat modifyContrat(Contrat entity);
    Client ajouterContratClient(Contrat c);
}
