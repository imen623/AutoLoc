package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipementServiceImpl implements EquipementService {

    private final EquipementRepository repository;

    @Override
    public List<Equipement> retrieveAllEquipements() {
        return repository.findAll();
    }

    @Override
    public Equipement retrieveEquipement(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Equipement addEquipement(Equipement entity) {
        return repository.save(entity);
    }

    @Override
    public void removeEquipement(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Equipement modifyEquipement(Equipement entity) {
        return repository.save(entity);
    }
}
