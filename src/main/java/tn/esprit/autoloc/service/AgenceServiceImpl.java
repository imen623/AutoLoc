package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements AgenceService {

    private final AgenceRepository agenceRepository;

    @Override
    public List<Agence> retrieveAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence retrieveAgence(Long agenceId) {
        return agenceRepository.findById(agenceId).get();
    }

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void removeAgence(Long agenceId) {
        agenceRepository.deleteById(agenceId);
    }

    @Override
    public Agence modifyAgence(Agence agence) {
        return agenceRepository.save(agence);
    }
}
