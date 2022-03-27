package l3miage.repository.impl;



import l3miage.model.Bornette;
import l3miage.model.Etat;
import l3miage.model.Velo;
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
    public List<Bornette> getAllVeloOkByStationId(Long idStation) {
        return entityManager.createNamedQuery("Bornette.findByVeloOkByStationId").setParameter("etat", Etat.ok).setParameter("id",idStation).getResultList();
    }
    @Override
    public List<Bornette> getAllBornetteVideByStationId(Long idStation) {
        return entityManager.createNamedQuery("Bornette.findBornetteVideByStationId").setParameter("id",idStation).getResultList();
    }
    @Override
    public Velo retraitVeloBornette(Long idBornette){

        entityManager.getTransaction().begin();
        Bornette bornette = findById(idBornette);
        Velo velo = bornette.getVelo();
        bornette.removeVelo();
        save(bornette);
        entityManager.persist(velo);
        entityManager.getTransaction().commit();
        return velo;
        //  entityManager.createNamedQuery("Bornette.retraitVelo").setParameter("id",idBornette).executeUpdate();
    }
    @Override
    public void renduVeloBornette(Velo velo, Long idBornette){
        //entityManager.createNamedQuery("Bornette.renduVelo").setParameter("idvelo",idVelo).setParameter("idbornette",idBornette).executeUpdate();
        entityManager.getTransaction().begin();
        Bornette bornette = findById(idBornette);
        bornette.setVelo(velo);
        save(bornette);
        entityManager.getTransaction().commit();
    }
}
