package l3miage.repository.impl;

import l3miage.model.Trajet;
import l3miage.repository.api.TrajetRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class TrajetRepositoryImpl extends BaseRepositoryImpl implements TrajetRepository{

    public TrajetRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Trajet entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Trajet entity) {
        entityManager.remove(entity);
    }

    @Override
    public Trajet findById(Long id) {
        return entityManager.find(Trajet.class,id);
    }

    @Override
    public List<Trajet> getAll() {
        return entityManager.createNamedQuery("Velo.findAll").getResultList();
    }
}
