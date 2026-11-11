package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @JsonIgnore
    //cascade: CascadeType.ALL: toutes les opérations effectuées sur la réservation seront propagées à l'entité Contrat associée. Par exemple, si vous supprimez une réservation, le contrat associé sera également supprimé.
    @OneToOne(mappedBy = "reservation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Contrat contrat;
}
