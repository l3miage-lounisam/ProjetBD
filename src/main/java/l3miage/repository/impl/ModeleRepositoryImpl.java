package l3miage.repository.impl;

import l3miage.model.Modele;
import l3miage.repository.api.ModeleRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ModeleRepositoryImpl extends BaseRepositoryImpl implements ModeleRepository {


    public ModeleRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Modele entity) {

    }

    @Override
    public void delete(Modele entity) {

    }

    @Override
    public Modele findById(Long id) {
        return null;
    }

    @Override
    public List<Modele> getAll() {
        return null;
    }
}
