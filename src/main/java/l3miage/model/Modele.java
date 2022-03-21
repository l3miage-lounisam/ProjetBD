package l3miage.model;

import javax.persistence.*;
import java.util.*;

/**
 * 
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Modele.findAll", query = "select m from Modele m")
})
public class Modele {


    /**
     * Default constructor
     */
    public Modele() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private Float coutHoraire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getCoutHoraire() {
        return coutHoraire;
    }

    public void setCoutHoraire(Float coutHoraire) {
        this.coutHoraire = coutHoraire;
    }
}