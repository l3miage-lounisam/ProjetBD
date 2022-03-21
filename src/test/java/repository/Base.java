package repository;

import l3miage.repository.RepositoryFactory;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class Base {

    protected EntityManager entityManager;
    protected RepositoryFactory daoFactory = new RepositoryFactory();


    @BeforeEach
    public final void setup() {
        entityManager = Persistence.createEntityManagerFactory("TEST")
                .createEntityManager();
    }
}
