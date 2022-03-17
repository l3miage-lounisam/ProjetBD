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

    }

    @Override
    public void delete(NonAbonne entity) {

    }

    @Override
    public NonAbonne findById(Long id) {
        return null;
    }

    @Override
    public List<NonAbonne> getAll() {
        return null;
    }
}
