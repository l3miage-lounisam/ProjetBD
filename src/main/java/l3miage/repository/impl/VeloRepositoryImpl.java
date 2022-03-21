package l3miage.repository.impl;


import l3miage.model.Velo;
import l3miage.repository.api.VeloRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class VeloRepositoryImpl extends BaseRepositoryImpl implements VeloRepository
{

    public VeloRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Velo entity) {
            entityManager.persist(entity);
    }

    @Override
    public void delete(Velo entity) {
            entityManager.remove(entity);
    }

    @Override
    public Velo findById(Long id) {
        return entityManager.find(Velo.class,id);
    }

    @Override
    public List<Velo> getAll() {
        return entityManager.createNamedQuery("Velo.findAll").getResultList();
    }
}