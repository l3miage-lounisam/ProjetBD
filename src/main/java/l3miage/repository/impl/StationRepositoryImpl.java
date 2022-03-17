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

    }

    @Override
    public void delete(Station entity) {

    }

    @Override
    public Station findById(Long id) {
        return null;
    }

    @Override
    public List<Station> getAll() {
        return null;
    }
}
