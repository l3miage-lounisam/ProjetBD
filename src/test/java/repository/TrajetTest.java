package repository;

import l3miage.model.*;
import l3miage.repository.api.StationRepository;
import l3miage.repository.api.TrajetRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrajetTest extends Base{
    TrajetRepository trajetRepository;

    @BeforeEach
    void before() {
        trajetRepository = daoFactory.newTrajetRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }
    
    // Enregistrer un trajet dans la bdd
    @Test
    void shouldSaveTrajet() throws InterruptedException {
        Station station1 = new Station();
        Station station2 = new Station();
        station1.setAdresse("2 rue du moulin");
        station2.setAdresse("2 rue de la place");

        Bornette bornette1 = new Bornette();
        Bornette bornette2 = new Bornette();
        bornette1.setStation(station1);
        bornette2.setStation(station1);

        Modele modele = new Modele();
        modele.setNom("VTT");
        modele.setCoutHoraire(10F);
        Velo v1 = new Velo();
        v1.setModele(modele);
        bornette1.setVelo(v1);

        Trajet trajet = new Trajet();
        trajet.setStationDepart(station1);
        trajet.setVelo(v1);

        entityManager.getTransaction().begin();
        entityManager.persist(station1);
        entityManager.persist(station2);

        entityManager.persist(modele);

        entityManager.persist(v1);

        entityManager.persist(bornette1);
        entityManager.persist(bornette2);


        trajetRepository.save(trajet);

        entityManager.getTransaction().commit();
        entityManager.detach(trajet);

        var pTrajet = trajetRepository.findById(trajet.getId());
        assertThat(pTrajet).isNotNull().isNotSameAs(trajet);
        assertThat(pTrajet.getStationDepart()).isEqualTo(trajet.getStationDepart());
        Thread.sleep(5000);
        entityManager.getTransaction().begin();
        pTrajet.setStationArrive(station2);
        trajetRepository.save(pTrajet);
        entityManager.getTransaction().commit();
        entityManager.detach(pTrajet);

    }

    // Enregistrer la fin d'un trajet dans la bdd
    @Test
    void shouldSaveFinTrajet() throws InterruptedException {
        Station station1 = new Station();
        Station station2 = new Station();
        station1.setAdresse("2 rue du moulin");
        station2.setAdresse("2 rue de la place");

        Bornette bornette1 = new Bornette();
        Bornette bornette2 = new Bornette();
        bornette1.setStation(station1);
        bornette2.setStation(station1);

        Modele modele = new Modele();
        modele.setNom("VTT");
        modele.setCoutHoraire(10F);
        Velo v1 = new Velo();
        v1.setModele(modele);
        bornette1.setVelo(v1);

        Trajet trajet = new Trajet();
        trajet.setStationDepart(station1);
        trajet.setVelo(v1);

        entityManager.getTransaction().begin();
        entityManager.persist(station1);
        entityManager.persist(station2);

        entityManager.persist(modele);

        entityManager.persist(v1);

        entityManager.persist(bornette1);
        entityManager.persist(bornette2);


        trajetRepository.save(trajet);

        entityManager.getTransaction().commit();
        entityManager.detach(trajet);

        var pTrajet = trajetRepository.findById(trajet.getId());

        Thread.sleep(5000);
        entityManager.getTransaction().begin();
        pTrajet.setStationArrive(station2);
        trajetRepository.save(pTrajet);
        entityManager.getTransaction().commit();
        entityManager.detach(pTrajet);
        Trajet p2Trajet = trajetRepository.findById(pTrajet.getId());
        assertThat(p2Trajet.getDuree()).isEqualTo(5);
    }
}
