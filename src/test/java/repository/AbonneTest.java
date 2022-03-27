package repository;

import l3miage.model.Abonne;
import l3miage.model.Sexe;
import l3miage.repository.api.AbonneRepository;
import l3miage.repository.api.BornetteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class AbonneTest extends Base {
    AbonneRepository abonneRepository;
    @BeforeEach
    void before() {
        abonneRepository = daoFactory.newAbonneRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveAbonne(){
        Abonne abonne = new Abonne();
        abonne.setNom("Dupont");
        abonne.setPrenom("Jean");
        abonne.setSexe(Sexe.homme);
        abonne.setAdresse("1 rue de l'arbre");
        abonne.setNumeroCB(45455454544L);
        entityManager.getTransaction().begin();
        abonneRepository.save(abonne);
        entityManager.getTransaction().commit();

        Abonne pAbonne = abonneRepository.findById(abonne.getId());
        assertSame(abonne.getNom(), pAbonne.getNom());
    }

}