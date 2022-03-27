package repository;

import l3miage.model.*;
import l3miage.repository.api.BornetteRepository;
import l3miage.repository.api.LocationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest extends Base{
    LocationRepository locationRepository;

    @BeforeEach
    void before() {
        locationRepository = daoFactory.newLocationRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }
    @Test
    void shouldFindLocationNonTermine() throws InterruptedException {
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

        Velo v2 = new Velo();
        v1.setModele(modele);
        bornette2.setVelo(v1);


        Trajet trajet1 = new Trajet();
        trajet1.setStationDepart(station1);
        trajet1.setVelo(v1);

        Trajet trajet2 = new Trajet();
        trajet2.setStationDepart(station1);
        trajet2.setVelo(v2);

        Location location = new Location();
        location.addTrajet(trajet1);
        location.addTrajet(trajet2);

        entityManager.getTransaction().begin();
        entityManager.persist(station1);
        entityManager.persist(station2);

        entityManager.persist(modele);

        entityManager.persist(v1);
        entityManager.persist(v2);


        entityManager.persist(bornette1);
        entityManager.persist(bornette2);


        entityManager.persist(trajet1);
        entityManager.persist(trajet2);
        locationRepository.save(location);
        entityManager.getTransaction().commit();
        entityManager.detach(location);

        assertThat(locationRepository.isLocationTermine(location.getId())).isFalse();

        /*var pTrajet = trajetRepository.findById(trajet.getId());
        assertThat(pTrajet).isNotNull().isNotSameAs(trajet);
        assertThat(pTrajet.getStationDepart()).isEqualTo(trajet.getStationDepart());
        Thread.sleep(5000);
        entityManager.getTransaction().begin();
        pTrajet.setStationArrive(station2);
        trajetRepository.save(pTrajet);
        entityManager.getTransaction().commit();
        entityManager.detach(pTrajet);
*/
    }

    @Test
    void shouldFindLocationTermine() throws InterruptedException {
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

        Velo v2 = new Velo();
        v2.setModele(modele);
        bornette2.setVelo(v1);


        Trajet trajet1 = new Trajet();
        trajet1.setStationDepart(station1);
        trajet1.setVelo(v1);

        Trajet trajet2 = new Trajet();
        trajet2.setStationDepart(station1);
        trajet2.setVelo(v2);

        Location location = new Location();
        location.addTrajet(trajet1);
        location.addTrajet(trajet2);

        entityManager.getTransaction().begin();
        entityManager.persist(station1);
        entityManager.persist(station2);

        entityManager.persist(modele);

        entityManager.persist(v1);
        entityManager.persist(v2);


        entityManager.persist(bornette1);
        entityManager.persist(bornette2);


        entityManager.persist(trajet1);
        entityManager.persist(trajet2);
        locationRepository.save(location);
        entityManager.getTransaction().commit();


;
        Thread.sleep(5000);
        entityManager.getTransaction().begin();

        trajet1.setStationArrive(station2);
        trajet2.setStationArrive(station2);
        entityManager.persist(trajet1);
        entityManager.persist(trajet2);

        location.calculPrix();
        locationRepository.save(location);
        entityManager.getTransaction().commit();


    }

}
