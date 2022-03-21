package l3miage.repository.impl;


import l3miage.model.NonAbonne;
import l3miage.repository.api.NonAbonneRepository;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

public class NonAbonneRepositoryImpl extends BaseRepositoryImpl implements NonAbonneRepository {

    public NonAbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(NonAbonne entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(NonAbonne entity) {
        entityManager.remove(entity);
    }

    @Override
    public NonAbonne findById(Long id) {
        return entityManager.find(NonAbonne.class,id);
    }

    @Override
    public List<NonAbonne> getAll() {
        return entityManager.createNamedQuery("NonAbonne.findAll").getResultList();
    }
}
