package repository;

import l3miage.model.Bornette;
import l3miage.model.Etat;
import l3miage.model.Station;
import l3miage.repository.api.BornetteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BornetteTest extends Base{
    BornetteRepository bornetteRepository;

    @BeforeEach
    void before() {
        bornetteRepository = daoFactory.newBornetteRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }
    @Test
    void shouldSaveBornette() {
        Station station = new Station();
        station.setAdresse("2 rue du moulin");
        Bornette bornette = new Bornette();
        bornette.setEtat(Etat.ok);
        entityManager.getTransaction().begin();
        entityManager.persist(station);
        bornetteRepository.save(bornette);
        entityManager.getTransaction().commit();
        entityManager.detach(station);
        var pBornette = bornetteRepository.findById(bornette.getId());
        //assertThat(pBornette).isNotNull().isNotSameAs(bornette);
        assertThat(pBornette.getEtat()).isEqualTo(bornette.getEtat());
    }
    @Test
    void shouldGetAllVeloOkByStationId(){
        Station station = new Station();
        station.setAdresse("2 rue du moulin");

    }

}
