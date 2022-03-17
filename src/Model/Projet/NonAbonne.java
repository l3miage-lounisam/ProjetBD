package Projet;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    public List<Location> locationsNonAbos;



    public List<Location> getLocationsNonAbos() {
        return locationsNonAbos;
    }

    public void setLocationsNonAbos(List<Location> locationsNonAbos) {
        this.locationsNonAbos = locationsNonAbos;
    }
}