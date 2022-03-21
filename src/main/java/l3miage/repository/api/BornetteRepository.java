package l3miage.repository.api;



import l3miage.model.Bornette;

import java.util.List;

public interface BornetteRepository extends Repository<Bornette, Long> {



    List<Bornette> getAllVeloOkByStationId(Long id);


    void retraitVeloBornette(Long id);
}
