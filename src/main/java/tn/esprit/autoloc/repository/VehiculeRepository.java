package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import java.util.*;


public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    // 1. Rechercher les véhicules d'une marque
    List<Vehicule> findByMarque(String marque);

    //2. Rechercher les véhicules dont la marque contient un mot
    List<Vehicule> findByMarqueContaining(String mot);

    //3. Rechercher les véhicules dont la marque commence par une valeur
    List<Vehicule> findByMarqueStartingWith(String valeur);

    //4. Rechercher les véhicules dont la marque se termine par une valeur
    List<Vehicule> findByMarqueEndingWith(String valeur);

    //5. Rechercher les véhicules par marque sans tenir compte de la casse
    List<Vehicule> findByMarqueIgnoreCase(String marque);

    //6. Rechercher les véhicules par modèle
    List<Vehicule> findByModele(String modele);

    //7. Vérifier si un véhicule existe avec une immatriculation donnée
    boolean existsByImmatriculation(String immatriculation);

    //8. Compter les véhicules d'une marque
    long countByMarque(String marque);

    //9. Véhicules dont le tarif est supérieur à une valeur
    List<Vehicule> findByTarifGreaterThan(Double valeur);

    //10. Véhicules dont le tarif est inférieur à une valeur
    List<Vehicule> findByTarifLessThan(Double valeur);

    //11. Véhicules dont le tarif est supérieur ou égal à une valeur
    List<Vehicule> findByTarifGreaterThanOrEqual(Double valeur);

    //12. Véhicules dont le tarif est compris entre deux valeurs
    List<Vehicule> findByTarifBetween(Double min, Double max);

    //13. Véhicules triés par tarif croissant
    List<Vehicule> findByOrderByTarifAsc();

    //14. Véhicules triés par tarif décroissant
    List<Vehicule> findByOrderByTarifDesc();

    //15. Véhicules d'une marque triés par tarif croissant
    List<Vehicule> findByMarqueOrderByTarifAsc(String marque);

    //16. Véhicules d'une marque dont le tarif dépasse une valeur
    List<Vehicule> findByMarqueByTarifGreaterThan(String marque, Double valeur);

    //17. Véhicules d'une marque OU d'un modèle
    List<Vehicule> findByMarqueOrModele(String marque, String modele);

    //18. Véhicules dont la marque figure dans une liste
    List<Vehicule> findByMarqueIn(List<String> marques);

    //19. Véhicules dont la marque ne figure pas dans une liste
    List<Vehicule> findByMarqueNotIn(List<String> marques);

    //20. Véhicules par le statut
    List<Vehicule> findByStatut(StatutVehicule statut);

    //21. Véhicules DISPONIBLES triés par tarif croissant
    List<Vehicule> findByStatutOrderByTarifAsc(StatutVehicule statut);

    //22. Véhicules appartenant à une agence
    List<Vehicule> findByAgenceId(Long agenceId);

    //23. Véhicules appartenant à une agence d'une ville donnée
    List<Vehicule> findByAgenceVille(String ville);
    //Agence Ville = relation attribut


    //24. Véhicules d'une agence dont le nom contient une valeur
    List<Vehicule> findByAgenceNomContaining(String valeur);

    //25. Véhicules d'une agence et d'une marque données
    List<Vehicule> findByAgenceIdAndMarque(Long agenceId, String marque);

    //26. Véhicules sans agence
    List<Vehicule> findByAgenceIsNull();

    //27. Véhicules affectés à une agence
    List<Vehicule> findByAgenceIsNotNull();

    //28. Compter les véhicules d'une agence
    long countByAgenceId(Long agenceId);

    //29. Vérifier si une agence possède des véhicules
    boolean existsByAgenceId(Long agenceId);
    //il existe au moins un véhicule lié à cette agence
    //ou bien dans agenceRepository, boolean existsByIdAgenceAndVehiculesIsNotEmpty(Long idAgence);
}
