package l3miage.repository.api;



import l3miage.model.Abonne;

import javax.persistence.ManyToOne;
import java.util.List;

public interface AbonneRepository extends Repository<Abonne, Long> {

    /**
     * Get the highest grades amongst all subjects
     * @param limit number of grades to return
     * @return a list of the nth best grades
     */



    /**
     * Get the highest grades for a given subject
     * @param limit number of grades to return
     * @return a list of the nth best grades for the subject
     */

}
