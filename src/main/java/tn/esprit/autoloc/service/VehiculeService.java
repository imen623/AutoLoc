package tn.esprit.autoloc.service;
import tn.esprit.autoloc.domain.Vehicule;
import java.util.List;


public interface VehiculeService {

    public List<Vehicule> retrieveAllVehicules  ();
    public Vehicule retrieveVehicule(Long vehiculeId);
    public Vehicule addVehicule(Vehicule vehicule);
    public void removeVehicule(Long vehiculeId);
    public Vehicule modifyVehicule(Vehicule vehicule);

    Vehicule affecterEquipementVehicule(Long idVehicule, Long idEquipement);


}
