package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;
import java.util.List;

public interface MaintenanceService {

    List<Maintenance> retrieveAllMaintenances();
    Maintenance retrieveMaintenance(Long id);
    Maintenance addMaintenance(Maintenance entity);
    void removeMaintenance(Long id);
    Maintenance modifyMaintenance(Maintenance entity);
}
