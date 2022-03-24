package l3miage.model;

import javax.persistence.*;
import java.util.*;

/**
 * 
 */
@NamedQueries({
        @NamedQuery(name = "Location.findAll", query = "select l from Location l")
})
@Entity
public class Location {

    /**
     * Default constructor
     */
    public Location() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    /**
     * 
     */
    private Integer dureeLoc;

    /**
     * 
     */
    private Float prix;

    /**
     * 
     */
    @OneToMany
    public List<Trajet> trajets;

    /**
     * 
     */
    @ManyToOne
    public Abonne abonne;

    /**
     * 
     */
    @ManyToOne
    public NonAbonne nonAbonne;

    public Abonne getAbonne() {
        return abonne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Double calculPrix() {
        // TODO implement here
        return null;
    }

    public Integer getDureeLoc() {
        return dureeLoc;
    }

    public void setDureeLoc(Integer dureeLoc) {
        this.dureeLoc = dureeLoc;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public List<Trajet> getTrajets() {
        return trajets;
    }

    public void setTrajets(List<Trajet> trajets) {
        this.trajets = trajets;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public NonAbonne getNonAbonne() {
        return nonAbonne;
    }

    public void setNonAbonne(NonAbonne nonAbonne) {
        this.nonAbonne = nonAbonne;
    }
}