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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Default constructor
     */
    public NonAbonne() {
        Random r = new Random();
        setCodeSecret(r.nextInt(10000));
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