package repository;

import l3miage.model.Station;
import l3miage.repository.api.StationRepository;
import l3miage.repository.api.VeloRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StationTest extends Base{
    StationRepository stationRepository;

    @BeforeEach
    void before() {
        stationRepository = daoFactory.newStationRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }
    
    // enregistrer une station dans la bdd avec des valeurs par défaut
    @Test
    void shouldSaveStation() {
            Station station = new Station();
            station.setAdresse("2 rue du moulin");
            entityManager.getTransaction().begin();
            stationRepository.save(station);
            entityManager.getTransaction().commit();
            entityManager.detach(station);
        var pStation = stationRepository.findById(station.getId());
        assertThat(pStation).isNotNull().isNotSameAs(station);
        assertThat(pStation.getAdresse()).isEqualTo(station.getAdresse());
    }
}
