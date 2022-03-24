package l3miage.repository.api;



import l3miage.model.Bornette;
import l3miage.model.Velo;

import java.util.List;

public interface BornetteRepository extends Repository<Bornette, Long> {



    List<Bornette> getAllVeloOkByStationId(Long id);


    List<Bornette> getAllBornetteVideByStationId(Long id);

    Velo retraitVeloBornette(Long id);


    void renduVeloBornette(Velo velo, Long idBornette);
}
