package l3miage.repository.api;

import l3miage.model.Trajet;

public interface TrajetRepository extends Repository<Trajet, Long> {

    Trajet findTrajetNonTermineByVelo(Long idVelo);
}
