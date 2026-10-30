package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;
import java.util.List;

public interface PaiementService {

    List<Paiement> retrieveAllPaiements();
    Paiement retrievePaiement(Long id);
    Paiement addPaiement(Paiement entity);
    void removePaiement(Long id);
    Paiement modifyPaiement(Paiement entity);
}
