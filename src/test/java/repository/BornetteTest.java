package repository;

import l3miage.model.*;
import l3miage.repository.api.BornetteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        bornette.setStation(station);
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
        Bornette bornette1 = new Bornette();
        Bornette bornette2 = new Bornette();
        Bornette bornette3 = new Bornette();
        Bornette bornette4 = new Bornette();
        Modele modele = new Modele();
        modele.setNom("VTT");
        Velo v1 = new Velo();
        v1.setModele(modele);
        Velo v2 = new Velo();
        v2.setModele(modele);
        Velo v3 = new Velo();
        v3.setModele(modele);
        v1.setEtat(Etat.ok);
        v2.setEtat(Etat.hs);
        v3.setEtat(Etat.ok);
        bornette1.setVelo(v1);
        bornette1.setStation(station);
        bornette2.setVelo(v2);
        bornette2.setStation(station);
        bornette3.setVelo(v3);
        bornette3.setStation(station);
        bornette4.setStation(station);
        entityManager.getTransaction().begin();
        entityManager.persist(station);
        entityManager.persist(modele);
        entityManager.persist(v1);
        entityManager.persist(v2);
        entityManager.persist(v3);

        bornetteRepository.save(bornette1);
        bornetteRepository.save(bornette2);
        bornetteRepository.save(bornette3);
        bornetteRepository.save(bornette4);

        entityManager.getTransaction().commit();

        List<Bornette> pBornettes = bornetteRepository.getAllVeloOkByStationId(station.getId());
        assertTrue(pBornettes.stream().anyMatch(s-> s.getId().equals(bornette1.getId())));
        assertTrue(pBornettes.stream().anyMatch(s-> s.getId().equals(bornette3.getId())));
    }
    @Test
    void shouldGetAllBornetteVideByStationId(){
        Station station = new Station();
        station.setAdresse("2 rue du moulin");
        Bornette bornette1 = new Bornette();
        Bornette bornette2 = new Bornette();
        Bornette bornette3 = new Bornette();
        Bornette bornette4 = new Bornette();
        Modele modele = new Modele();
        modele.setNom("VTT");
        Velo v1 = new Velo();
        v1.setModele(modele);
        Velo v2 = new Velo();
        v2.setModele(modele);
        Velo v3 = new Velo();
        v3.setModele(modele);
        v1.setEtat(Etat.ok);
        v2.setEtat(Etat.hs);
        v3.setEtat(Etat.ok);
        bornette1.setVelo(v1);
        bornette1.setStation(station);
        bornette2.setStation(station);
        bornette3.setVelo(v3);
        bornette3.setStation(station);
        bornette4.setStation(station);
        entityManager.getTransaction().begin();
        entityManager.persist(station);
        entityManager.persist(modele);
        entityManager.persist(v1);
        entityManager.persist(v2);
        entityManager.persist(v3);

        bornetteRepository.save(bornette1);
        bornetteRepository.save(bornette2);
        bornetteRepository.save(bornette3);
        bornetteRepository.save(bornette4);

        entityManager.getTransaction().commit();

        List<Bornette> pBornettes = bornetteRepository.getAllBornetteVideByStationId(station.getId());
        assertTrue(pBornettes.stream().anyMatch(s-> s.getId().equals(bornette2.getId())));
        assertTrue(pBornettes.stream().anyMatch(s-> s.getId().equals(bornette4.getId())));
    }
    @Test
    void testRetraitVelo(){
        Station station = new Station();
        station.setAdresse("2 rue du moulin");
        Bornette bornette1 = new Bornette();
        Modele modele = new Modele();
        modele.setNom("VTT");
        Velo v1 = new Velo();
        v1.setModele(modele);

        v1.setEtat(Etat.ok);

        bornette1.setVelo(v1);
        bornette1.setStation(station);

        entityManager.getTransaction().begin();
        entityManager.persist(station);
        entityManager.persist(modele);
        entityManager.persist(v1);

        bornetteRepository.save(bornette1);


        entityManager.getTransaction().commit();

        bornetteRepository.retraitVeloBornette(bornette1.getId());
        Bornette pBornette1 = bornetteRepository.findById(bornette1.getId());
        assertNull(pBornette1.getVelo());
    }
    @Test
    void testRenduVelo(){
        Station station = new Station();
        station.setAdresse("2 rue du moulin");
        Bornette bornette1 = new Bornette();
        Bornette bornette2 = new Bornette();

        Modele modele = new Modele();
        modele.setNom("VTT");
        Velo v1 = new Velo();
        v1.setModele(modele);
        Velo v2 = new Velo();
        v2.setModele(modele);

        v1.setEtat(Etat.ok);

        bornette1.setVelo(v1);
        bornette1.setStation(station);

        entityManager.getTransaction().begin();
        entityManager.persist(station);
        entityManager.persist(modele);
        entityManager.persist(v1);
        entityManager.persist(v2);

        bornetteRepository.save(bornette1);
        bornetteRepository.save(bornette2);


        entityManager.getTransaction().commit();

        bornetteRepository.renduVeloBornette(v2,bornette2.getId());
        Bornette pBornette2 = bornetteRepository.findById(bornette2.getId());
        assertSame(pBornette2.getVelo().getId(), v2.getId());
    }
}
