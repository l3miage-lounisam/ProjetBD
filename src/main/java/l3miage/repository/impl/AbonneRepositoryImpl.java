package l3miage.repository.impl;


import l3miage.model.Abonne;
import l3miage.repository.api.AbonneRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class AbonneRepositoryImpl extends BaseRepositoryImpl implements AbonneRepository {
    public AbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Abonne entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Abonne entity) {
        entityManager.remove(entity);
    }

    @Override
    public Abonne findById(Long id) {
       return entityManager.find(Abonne.class,id);
    }

    @Override
    public List<Abonne> getAll() {
        return entityManager.createNamedQuery("Abonne.findAll").getResultList();
    }



}
