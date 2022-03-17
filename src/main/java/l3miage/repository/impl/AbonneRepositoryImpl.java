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

    }

    @Override
    public void delete(Abonne entity) {

    }

    @Override
    public Abonne findById(Long id) {
        return null;
    }

    @Override
    public List<Abonne> getAll() {
        return null;
    }



}
