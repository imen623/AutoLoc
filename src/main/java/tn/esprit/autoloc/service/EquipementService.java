package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;
import java.util.List;

public interface EquipementService {

    List<Equipement> retrieveAllEquipements();
    Equipement retrieveEquipement(Long id);
    Equipement addEquipement(Equipement entity);
    void removeEquipement(Long id);
    Equipement modifyEquipement(Equipement entity);

}
