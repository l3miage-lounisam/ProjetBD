package l3miage.model;

import javax.persistence.*;
import java.util.*;

/**
 * création d'une classe modéle qui définit le modéle d'un velo,
 * chaque modéle a un nom et un coutHoraire, un vélo a un et un seul modele 
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
    //le cout de la location qui dépent du modéle d'un velo est compté a l'heure
    public Float getCoutHoraire() {
        return coutHoraire;
    }

    public void setCoutHoraire(Float coutHoraire) {
        this.coutHoraire = coutHoraire;
    }
}
