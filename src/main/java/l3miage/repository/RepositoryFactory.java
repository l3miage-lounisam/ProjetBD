package l3miage.repository;



import l3miage.repository.api.*;
import l3miage.repository.impl.*;

import javax.persistence.EntityManager;

public class RepositoryFactory {

    public AbonneRepository newAbonneRepository(EntityManager entityManager) {
        return new AbonneRepositoryImpl(entityManager);
    }
    public BornetteRepository newBornetteRepository(EntityManager entityManager) {
        return new BornetteRepositoryImpl(entityManager);
    }

    public DefinitionStationRepository newDefinitionStationRepository(EntityManager entityManager) {
        return new DefinitionStationRepositoryImpl(entityManager);
    }

    public LocationRepository newLocationRepository(EntityManager entityManager) {
        return new LocationRepositoryImpl(entityManager);
    }
    public ModeleRepository newModeleRepository(EntityManager entityManager){
        return new ModeleRepositoryImpl(entityManager);
    }

    public NonAbonneRepository newNonAbonneRepository(EntityManager entityManager){
        return new NonAbonneRepositoryImpl(entityManager);
    }

    public StationRepository newStationRepository(EntityManager entityManager){
        return new StationRepositoryImpl(entityManager);
    }

    public TrajetRepository newTrajetRepository(EntityManager entityManager){
        return new TrajetRepositoryImpl(entityManager);
    }

    public VeloRepository newVeloRepository(EntityManager entityManager){
        return new VeloRepositoryImpl(entityManager);
    }
}
