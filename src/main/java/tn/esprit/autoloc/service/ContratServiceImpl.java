package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements ContratService {

    private final ContratRepository repository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return repository.findAll();
    }

    @Override
    public Contrat retrieveContrat(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Contrat addContrat(Contrat entity) {
        return repository.save(entity);
    }

    @Override
    public void removeContrat(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Contrat modifyContrat(Contrat entity) {
        return repository.save(entity);
    }
}
