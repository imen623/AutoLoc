package tn.esprit.autoloc;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ClientReservationsEndpointTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EntityManager em;

    @Test
    void createsClientAndPersistsReservationLinksWithoutCircularJson() throws Exception {
        mockMvc.perform(post("/client/add-client-reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "nom": "Client avec reservations",
                                  "email": "reservations@example.com",
                                  "reservations": [
                                    {"dateDebut": "2026-12-01", "dateFin": "2026-12-03"},
                                    {"dateDebut": "2026-12-10", "dateFin": "2026-12-12"}
                                  ]
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idClient").isNumber())
                .andExpect(jsonPath("$.reservations.length()").value(2))
                .andExpect(jsonPath("$.reservations[0].idReservation").isNumber())
                .andExpect(jsonPath("$.reservations[1].idReservation").isNumber())
                .andExpect(jsonPath("$.reservations[0].client").doesNotExist());

        em.flush();
        em.clear();

        Client client = em.createQuery("select c from Client c where c.email = :email", Client.class)
                .setParameter("email", "reservations@example.com")
                .getSingleResult();
        assertEquals(2, client.getReservations().size());
        assertEquals(2, em.createQuery("select r from Reservation r where r.client.idClient = :id", Reservation.class)
                .setParameter("id", client.getIdClient())
                .getResultList().size());
    }

    @Test
    void createsClientWhenReservationsAreOmitted() throws Exception {
        mockMvc.perform(post("/client/add-client-reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"nom": "Client sans reservation", "email": "client@example.com"}
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idClient").isNumber())
                .andExpect(jsonPath("$.reservations").isEmpty());

        em.flush();
        em.clear();

        Client client = em.createQuery("select c from Client c where c.email = :email", Client.class)
                .setParameter("email", "client@example.com")
                .getSingleResult();
        assertTrue(client.getReservations().isEmpty());
    }
}
