package l3miage.model;

import java.util.*;
import javax.persistence.*;

/**
 * 
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Abonne.findAll", query = "select a from Abonne a"),
})
public class Abonne extends Client {



    /**
     * Default constructor
     */


    /**
     * 
     */

    @Column(nullable = false)
    private String nom;

    /**
     * 
     */
    @Column(nullable = false)
    private String prenom;

    /**
     * 
     */
    private Date dateN;

    /**
     * 
     */
    private Sexe sexe;

    /**
     * 
     */
    private String adresse;

    /**
     * 
     */
    private Date dateDebutAb;

    /**
     * 
     */
    private Integer creditTemps;

    /**
     * 
     */
    @OneToMany
    public List<Location> locations;



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateN() {
        return dateN;
    }

    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateDebutAb() {
        return dateDebutAb;
    }

    public void setDateDebutAb(Date dateDebutAb) {
        this.dateDebutAb = dateDebutAb;
    }

    public Integer getCreditTemps() {
        return creditTemps;
    }

    public void setCreditTemps(Integer creditTemps) {
        this.creditTemps = creditTemps;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}