package l3miage.model;

import javax.persistence.*;
import java.util.*;

/**
 * création de la classe NonAbonne qui hérite de la classe Client, chaque client NonAbonne
 * possede un numeroCB et un codeScret
 * 
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "NonAbonne.findAll", query = "select n from NonAbonne n"),
        @NamedQuery(name = "NonAbonne.findByCodeSecret", query = "select n from NonAbonne n where n.codeSecret = :codeSecret"),
        @NamedQuery(name = "NonAbonne.findAllCodeSecret", query = "select n.codeSecret from NonAbonne n"),
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
