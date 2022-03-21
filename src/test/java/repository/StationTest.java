package repository;

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
    @Test
    void shouldSaveStation() {

    }
}
