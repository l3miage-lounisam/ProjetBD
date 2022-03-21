package l3miage.repository.api;


import l3miage.model.Etat;
import l3miage.model.Velo;

public interface VeloRepository extends Repository<Velo, Long> {

    void setEtatVeloById(Etat etat, Long id);
}
