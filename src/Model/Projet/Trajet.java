package Projet;

import javax.persistence.*;
import java.util.*;

/**
 * 
 */
@Entity
public class Trajet {

    /**
     * Default constructor
     */


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 
     */
    public Date dateDebutTrajet;

    /**
     * 
     */
    public Date dateFinTrajet;

    /**
     * 
     */
    public Integer duree;

    /**
     * 
     */
    public Float prix;

    /**
     * 
     */
    @ManyToOne
    public Station stationDepart;

    /**
     * 
     */
    @ManyToOne
    public Station stationArrive;

    /**
     * 
     */


    /**
     * 
     */
    @ManyToOne
    public Velo velo;



    public Station getStationArrive() {
        return stationArrive;
    }

    public Station getStationDepart() {
        return stationDepart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebutTrajet() {
        return dateDebutTrajet;
    }

    public void setDateDebutTrajet(Date dateDebutTrajet) {
        this.dateDebutTrajet = dateDebutTrajet;
    }

    public Date getDateFinTrajet() {
        return dateFinTrajet;
    }

    public void setDateFinTrajet(Date dateFinTrajet) {
        this.dateFinTrajet = dateFinTrajet;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setStationDepart(Station stationDepart) {
        this.stationDepart = stationDepart;
    }

    public void setStationArrive(Station stationArrive) {
        this.stationArrive = stationArrive;
    }

    public Velo getVelo() {
        return velo;
    }

    public void setVelo(Velo velo) {
        this.velo = velo;
    }

    /**
     * 
     */

    public void CalculPrixTrajet() {
        // TODO implement here
    }

}