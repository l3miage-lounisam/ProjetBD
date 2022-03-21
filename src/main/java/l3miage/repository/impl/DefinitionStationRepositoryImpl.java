package l3miage.repository.impl;



import l3miage.model.DefinitionStation;
import l3miage.model.Station;
import l3miage.repository.api.DefinitionStationRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class DefinitionStationRepositoryImpl extends BaseRepositoryImpl implements DefinitionStationRepository{

    public DefinitionStationRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }




    @Override
    public void save(DefinitionStation entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(DefinitionStation entity) {
        entityManager.remove(entity);
    }

    @Override
    public DefinitionStation findById(Long id) {
        return entityManager.find(DefinitionStation.class,id);
    }

    @Override
    public List<DefinitionStation> getAll() {
        return entityManager.createNamedQuery("DefinitionStation.findAll").getResultList();
    }
}
