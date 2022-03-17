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

    }

    @Override
    public void delete(Location entity) {

    }

    @Override
    public Location findById(Long id) {
        return null;
    }

    @Override
    public List<Location> getAll() {
        return null;
    }
}
