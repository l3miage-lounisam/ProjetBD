package l3miage.repository.impl;



import l3miage.model.Location;
import l3miage.repository.api.LocationRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class LocationRepositoryImpl extends BaseRepositoryImpl implements LocationRepository {


    public LocationRepositoryImpl(EntityManager entityManager) {

        super(entityManager);
    }

    @Override
    public void save(Location entity) {
            entityManager.persist(entity);
    }

    @Override
    public void delete(Location entity) {
        entityManager.remove(entity);
    }

    @Override
    public Location findById(Long id) {
        return entityManager.find(Location.class,id);
    }

    @Override
    public List<Location> getAll() {
        return entityManager.createNamedQuery("Location.findAll").getResultList();
    }
}