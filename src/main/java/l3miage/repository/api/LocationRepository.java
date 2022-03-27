package l3miage.repository.api;



import l3miage.model.Location;

import java.util.List;

public interface LocationRepository extends Repository<Location, Long> {


    Location findLocationNonTermineByAbonneCodeSecret(Long codesecret);

    Location findLocationNonTermineByNonAbonneCodeSecret(Long codesecret);

    boolean isLocationTermine(Long idlocation);
}
