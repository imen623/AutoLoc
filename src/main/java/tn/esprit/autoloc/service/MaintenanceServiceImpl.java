package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository repository;

    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        return repository.findAll();
    }

    @Override
    public Maintenance retrieveMaintenance(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Maintenance addMaintenance(Maintenance entity) {
        return repository.save(entity);
    }

    @Override
    public void removeMaintenance(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Maintenance modifyMaintenance(Maintenance entity) {
        return repository.save(entity);
    }
}
