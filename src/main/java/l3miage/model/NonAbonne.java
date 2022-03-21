package l3miage.model;

import javax.persistence.*;
import java.util.*;

/**
 * 
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "NonAbonne.findAll", query = "select n from NonAbonne n")
})
public class NonAbonne extends Client {

    /**
     * Default constructor
     */
    public NonAbonne() {
    }

    /**
     * 
     */
    @OneToMany
    public List<Location> locationsNonAbos;



    public List<Location> getLocationsNonAbos() {
        return locationsNonAbos;
    }

    public void setLocationsNonAbos(List<Location> locationsNonAbos) {
        this.locationsNonAbos = locationsNonAbos;
    }
}