package l3miage.repository.impl;


import l3miage.model.Station;
import l3miage.repository.api.StationRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class StationRepositoryImpl extends BaseRepositoryImpl implements StationRepository {

    public StationRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Station entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Station entity) {
        entityManager.remove(entity);
    }

    @Override
    public Station findById(Long id) {
        return entityManager.find(Station.class,id);
    }

    @Override
    public List<Station> getAll() {
        return entityManager.createNamedQuery("Station.findAll").getResultList();
    }
}
