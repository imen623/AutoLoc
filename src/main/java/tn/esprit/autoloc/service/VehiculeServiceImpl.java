package tn.esprit.autoloc.service;
import lombok.AllArgsConstructor;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service  
@AllArgsConstructor
public class VehiculeServiceImpl implements VehiculeService {

    private final EquipementRepository equipementRepository;
    VehiculeRepository vehiculeRepository;

    public List<Vehicule> retrieveAllVehicules  () {
    return vehiculeRepository.findAll();
    }
    public Vehicule retrieveVehicule(Long vehiculeId) {  
    return vehiculeRepository.findById(vehiculeId).get();
    }
    public Vehicule addVehicule(Vehicule c) {  
    return vehiculeRepository.save(c);
    }
    public void removeVehicule(Long vehiculeId) {  
    vehiculeRepository.deleteById(vehiculeId);
    }
    public Vehicule modifyVehicule(Vehicule vehicule) {
    return vehiculeRepository.save(vehicule);
    }


    @Override
    public Vehicule affecterEquipementVehicule(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        Equipement equipement = equipementRepository.findById(idEquipement).orElse(null);
        assert vehicule != null;
        vehicule.getEquipements().add(equipement);
        return vehiculeRepository.save(vehicule);

    }
}