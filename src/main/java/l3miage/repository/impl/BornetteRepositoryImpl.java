package l3miage.repository.impl;



import l3miage.model.Bornette;
import l3miage.repository.api.BornetteRepository;

import javax.persistence.EntityManager;

import java.util.List;

public class BornetteRepositoryImpl extends BaseRepositoryImpl implements BornetteRepository {


    public BornetteRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Bornette entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Bornette entity) {
        entityManager.remove(entity);
    }

    @Override
    public Bornette findById(Long id) {

         return entityManager.find(Bornette.class,id);
    }

    @Override
    public List<Bornette> getAll() {
        return entityManager.createNamedQuery("Bornette.findAll").getResultList();
    }
    @Override
    public List<Bornette> getAllVeloOkByStationId(Long id) {
        return entityManager.createNamedQuery("Bornette.findByVeloOkByStationId").setParameter("id",id).getResultList();
    }
    @Override
    public List<Bornette> getAllBornetteVideByStationId(Long id) {
        return entityManager.createNamedQuery("Bornette.findBornetteVideByStationId").setParameter("id",id).getResultList();
    }
    @Override
    public void retraitVeloBornette(Long id){
        entityManager.createNamedQuery("Bornette.retraitVelo").setParameter("id",id).executeUpdate();
    }
    @Override
    public void renduVeloBornette(Long idVelo, Long idBornette){
        entityManager.createNamedQuery("Bornette.renduVelo").setParameter("idvelo",idVelo).setParameter("idbornette",idBornette).executeUpdate();
    }
}
