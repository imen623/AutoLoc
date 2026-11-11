-- Remplace les donnees de autoloc_db par quatre exemples par table principale.
-- La table intermediaire vehicule_equipement reste vide.
USE autoloc_db;
SET NAMES utf8mb4;
SET SESSION FOREIGN_KEY_CHECKS = 1;

START TRANSACTION;

DELETE FROM vehicule_equipement;
DELETE FROM paiement;
DELETE FROM contrat;
DELETE FROM maintenance;
DELETE FROM reservation;
DELETE FROM employe;
DELETE FROM vehicule;
DELETE FROM equipement;
DELETE FROM client;
DELETE FROM agence;

INSERT INTO agence (id_agence, nom, ville, adresse, telephone) VALUES
    (1, 'AutoLoc Tunis', 'Tunis', '12 Avenue Habib Bourguiba', '71100001'),
    (2, 'AutoLoc Sousse', 'Sousse', '25 Avenue Hedi Chaker', '73100002'),
    (3, 'AutoLoc Sfax', 'Sfax', '8 Route de Tunis', '74100003'),
    (4, 'AutoLoc Djerba', 'Djerba', '15 Avenue Farhat Hached', '75100004');

INSERT INTO client (id_client, nom, prenom, email, telephone, num_permis, date_inscription) VALUES
    (1, 'Ben Ali', 'Ahmed', 'ahmed.benali@example.com', '20100001', 'TN-PERMIS-001', '2026-10-01'),
    (2, 'Trabelsi', 'Amira', 'amira.trabelsi@example.com', '22100002', 'TN-PERMIS-002', '2026-10-05'),
    (3, 'Mansouri', 'Youssef', 'youssef.mansouri@example.com', '24100003', 'TN-PERMIS-003', '2026-10-10'),
    (4, 'Gharbi', 'Nour', 'nour.gharbi@example.com', '26100004', 'TN-PERMIS-004', '2026-10-15');

INSERT INTO equipement (id_equipement, libelle) VALUES
    (1, 'GPS'),
    (2, 'Siege enfant'),
    (3, 'Chaine a neige'),
    (4, 'Coffre de toit');

INSERT INTO employe (id_employe, nom, prenom, role, agence_id) VALUES
    (1, 'Jlassi', 'Sami', 'MANAGER', 1),
    (2, 'Saidi', 'Ines', 'AGENT', 2),
    (3, 'Ayari', 'Mehdi', 'MANAGER', 3),
    (4, 'Hamdi', 'Mariem', 'AGENT', 4);

INSERT INTO vehicule (id_vehicule, immatriculation, marque, modele, categorie, tarif_journalier, statut, agence_id) VALUES
    (1, '210-TN-1001', 'Toyota', 'Yaris', 'CITADINE', 120.00, 'DISPONIBLE', 1),
    (2, '220-TN-1002', 'Peugeot', '508', 'BERLINE', 180.00, 'DISPONIBLE', 2),
    (3, '230-TN-1003', 'Hyundai', 'Tucson', 'SUV', 250.00, 'DISPONIBLE', 3),
    (4, '240-TN-1004', 'Renault', 'Kangoo', 'UTILITAIRE', 160.00, 'DISPONIBLE', 4);

INSERT INTO maintenance (id_maintenance, date_debut, date_fin, description, vehicule_id) VALUES
    (1, '2026-10-02', '2026-10-03', 'Vidange et remplacement du filtre a huile', 1),
    (2, '2026-10-04', '2026-10-05', 'Controle et remplacement des plaquettes de frein', 2),
    (3, '2026-10-06', '2026-10-07', 'Remplacement des pneus avant', 3),
    (4, '2026-10-08', '2026-10-09', 'Revision generale et controle des niveaux', 4);

INSERT INTO reservation (id_reservation, date_debut, date_fin, statut, client_id, vehicule_id) VALUES
    (1, '2026-11-10', '2026-11-13', 'CONFIRMEE', 1, 1),
    (2, '2026-11-14', '2026-11-18', 'CONFIRMEE', 2, 2),
    (3, '2026-11-20', '2026-11-22', 'CONFIRMEE', 3, 3),
    (4, '2026-11-24', '2026-11-27', 'CONFIRMEE', 4, 4);

INSERT INTO contrat (id_contrat, date_signature, montant_total, valide, reservation_id) VALUES
    (1, '2026-11-05', 360.00, b'1', 1),
    (2, '2026-11-06', 720.00, b'1', 2),
    (3, '2026-11-07', 500.00, b'1', 3),
    (4, '2026-11-08', 480.00, b'1', 4);

INSERT INTO paiement (id_paiement, date_paiement, mode_paiement, montant, contrat_id) VALUES
    (1, '2026-11-05', 'CARTE', 360.00, 1),
    (2, '2026-11-06', 'VIREMENT', 720.00, 2),
    (3, '2026-11-07', 'ESPECES', 500.00, 3),
    (4, '2026-11-08', 'CARTE', 480.00, 4);

COMMIT;

-- Les lignes ont les identifiants 1 a 4 ; la prochaine insertion recevra 5.
ALTER TABLE agence AUTO_INCREMENT = 5;
ALTER TABLE client AUTO_INCREMENT = 5;
ALTER TABLE contrat AUTO_INCREMENT = 5;
ALTER TABLE employe AUTO_INCREMENT = 5;
ALTER TABLE equipement AUTO_INCREMENT = 5;
ALTER TABLE maintenance AUTO_INCREMENT = 5;
ALTER TABLE paiement AUTO_INCREMENT = 5;
ALTER TABLE reservation AUTO_INCREMENT = 5;
ALTER TABLE vehicule AUTO_INCREMENT = 5;

SELECT 'agence' AS table_name, COUNT(*) AS lignes, MIN(id_agence) AS id_min, MAX(id_agence) AS id_max FROM agence
UNION ALL SELECT 'client', COUNT(*), MIN(id_client), MAX(id_client) FROM client
UNION ALL SELECT 'contrat', COUNT(*), MIN(id_contrat), MAX(id_contrat) FROM contrat
UNION ALL SELECT 'employe', COUNT(*), MIN(id_employe), MAX(id_employe) FROM employe
UNION ALL SELECT 'equipement', COUNT(*), MIN(id_equipement), MAX(id_equipement) FROM equipement
UNION ALL SELECT 'maintenance', COUNT(*), MIN(id_maintenance), MAX(id_maintenance) FROM maintenance
UNION ALL SELECT 'paiement', COUNT(*), MIN(id_paiement), MAX(id_paiement) FROM paiement
UNION ALL SELECT 'reservation', COUNT(*), MIN(id_reservation), MAX(id_reservation) FROM reservation
UNION ALL SELECT 'vehicule', COUNT(*), MIN(id_vehicule), MAX(id_vehicule) FROM vehicule;

SELECT COUNT(*) AS lignes_table_intermediaire FROM vehicule_equipement;
