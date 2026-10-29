package tn.esprit.autoloc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AssociationsJpaTests {
    @PersistenceContext
    private EntityManager em;

    private Vehicule vehicule(String immatriculation) {
        Vehicule v = new Vehicule();
        v.setImmatriculation(immatriculation);
        v.setMarque("Toyota");
        v.setModele("Yaris");
        v.setCategorie(CategorieVehicule.CITADINE);
        v.setTarifJournalier(new BigDecimal("100.00"));
        v.setStatut(StatutVehicule.DISPONIBLE);
        return v;
    }

    @Test
    void agenceClientEtReservationsSontRelies() {
        Agence agence = new Agence();
        Employe employe = new Employe();
        employe.setAgence(agence);
        agence.getEmployes().add(employe);
        Vehicule v = vehicule("123-TN-456");
        v.setAgence(agence);
        agence.getVehicules().add(v);
        Client client = new Client();
        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setVehicule(v);
        client.getReservations().add(reservation);
        v.getReservations().add(reservation);
        em.persist(agence);
        em.persist(employe);
        em.persist(v);
        em.persist(client);
        em.persist(reservation);
        em.flush();
        em.clear();
        Agence saved = em.find(Agence.class, agence.getIdAgence());
        assertFalse(em.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(saved, "vehicules"));
        assertEquals(1, saved.getEmployes().size());
        assertEquals(1, saved.getVehicules().size());
        assertEquals(client.getIdClient(), em.find(Reservation.class, reservation.getIdReservation()).getClient().getIdClient());
        assertEquals(1, em.find(Client.class, client.getIdClient()).getReservations().size());
        assertEquals(1, em.find(Vehicule.class, v.getIdVehicule()).getReservations().size());
    }

    @Test
    void contratEtPaiementsSontCascadesEtOrphelinsSupprimes() {
        Reservation reservation = new Reservation();
        Contrat contrat = new Contrat();
        reservation.setContrat(contrat);
        contrat.setReservation(reservation);
        Paiement paiement = new Paiement();
        paiement.setMontant(new BigDecimal("200.00"));
        contrat.getPaiements().add(paiement);
        paiement.setContrat(contrat);
        em.persist(reservation);
        em.flush();
        Long contratId = contrat.getIdContrat();
        Long paiementId = paiement.getIdPaiement();
        em.clear();
        Reservation saved = em.find(Reservation.class, reservation.getIdReservation());
        assertEquals(1, saved.getContrat().getPaiements().size());
        Paiement paiementRetire = saved.getContrat().getPaiements().remove(0);
        paiementRetire.setContrat(null);
        em.flush();
        assertNull(em.find(Paiement.class, paiementId));
        saved.setContrat(null);
        em.flush();
        assertNull(em.find(Contrat.class, contratId));
    }

    @Test
    void suppressionVehiculeConserveEquipementPartage() {
        Equipement gps = new Equipement();
        gps.setLibelle("GPS");
        Vehicule premier = vehicule("111-TN-111");
        Vehicule second = vehicule("222-TN-222");
        premier.getEquipements().add(gps);
        second.getEquipements().add(gps);
        Maintenance maintenance = new Maintenance();
        premier.getMaintenances().add(maintenance);
        maintenance.setVehicule(premier);
        em.persist(premier);
        em.persist(second);
        em.flush();
        Long maintenanceId = maintenance.getIdMaintenance();
        Long equipementId = gps.getIdEquipement();
        em.clear();
        assertEquals(2, em.find(Equipement.class, equipementId).getVehicules().size());
        em.remove(em.find(Vehicule.class, premier.getIdVehicule()));
        em.flush();
        em.clear();
        assertNull(em.find(Maintenance.class, maintenanceId));
        assertNotNull(em.find(Equipement.class, equipementId));
        assertEquals(1, em.find(Vehicule.class, second.getIdVehicule()).getEquipements().size());
    }

    @Test
    void maintenanceRetireeEstSupprimee() {
        Vehicule v = vehicule("333-TN-333");
        Maintenance maintenance = new Maintenance();
        v.getMaintenances().add(maintenance);
        maintenance.setVehicule(v);
        em.persist(v);
        em.flush();
        Long id = maintenance.getIdMaintenance();
        v.getMaintenances().remove(maintenance);
        maintenance.setVehicule(null);
        em.flush();
        em.clear();
        assertNull(em.find(Maintenance.class, id));
    }
}
