package l3miage.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.*;

/**
 * 
 */
@Entity
public class NonAbonne extends Client {

    /**
     * Default constructor
     */
    public NonAbonne() {
    }

    /**
     * 
     */
    @ManyToOne
    public List<Location> locationsNonAbos;



    public List<Location> getLocationsNonAbos() {
        return locationsNonAbos;
    }

    public void setLocationsNonAbos(List<Location> locationsNonAbos) {
        this.locationsNonAbos = locationsNonAbos;
    }
}