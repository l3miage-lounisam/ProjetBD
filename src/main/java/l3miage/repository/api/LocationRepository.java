package l3miage.repository.api;



import l3miage.model.Location;

import java.util.List;

public interface LocationRepository extends Repository<Location, Long> {



    Location findLocationNonTermineByAbonneCodeSecret(Integer codesecret);

    Location findLocationNonTermineByNonAbonneCodeSecret(Integer codesecret);

    boolean isLocationTermine(Long idlocation);
}
