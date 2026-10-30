package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository repository;

    @Override
    public List<Paiement> retrieveAllPaiements() {
        return repository.findAll();
    }

    @Override
    public Paiement retrievePaiement(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Paiement addPaiement(Paiement entity) {
        return repository.save(entity);
    }

    @Override
    public void removePaiement(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Paiement modifyPaiement(Paiement entity) {
        return repository.save(entity);
    }
}
