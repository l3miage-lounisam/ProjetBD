package l3miage.repository.api;



import l3miage.model.Bornette;

import java.util.List;

public interface BornetteRepository extends Repository<Bornette, Long> {



    List<Bornette> getAllVeloOkByStationId(Long id);


    List<Bornette> getAllBornetteVideByStationId(Long id);

    void retraitVeloBornette(Long id);

    void renduVeloBornette(Long idVelo, Long idBornette);
}
