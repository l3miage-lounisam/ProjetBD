package l3miage.model;

import javax.persistence.*;
import java.util.*;

/**
 * creation de la classe trajet, chaque trajet est identifier par 
 * une dateDebutTrajet, dateFinTrajet, une duree et un prix
 * un trajte effectuer par un velo ,entre une station de depart et une station d'arriver
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Trajet.findAll", query = "select t from Trajet t"),
        @NamedQuery(name = "Trajet.findByVelo_IdAndDateFinTrajetIsNull", query = "select t from Trajet t where t.velo.id = :id and t.dateFinTrajet is null")
})
public class Trajet {

    /**
     * Default constructor
     */
public Trajet(){
}

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

    //calcule du la duree du trajet 
    public void calculDuree(){
       this.duree = Math.toIntExact((dateFinTrajet.getTime() - dateDebutTrajet.getTime()) /1000 );
    }

    //la station d'arriver
    public Station getStationArrive() {
        return stationArrive;
    }
    
    //station de depart
    public Station getStationDepart() {
        return stationDepart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //date de debut du trajet
    public Date getDateDebutTrajet() {
        return dateDebutTrajet;
    }

    public void setDateDebutTrajet(Date dateDebutTrajet) {
        this.dateDebutTrajet = dateDebutTrajet;
    }

    //date de fin de trajet
    public Date getDateFinTrajet() {
        return dateFinTrajet;
    }

    public void setDateFinTrajet(Date dateFinTrajet) {
        this.dateFinTrajet = dateFinTrajet;

    }

    //la duree du trajet
    public Integer getDuree() {
        return duree;
    }

    // le prix du trajet
    public Float getPrix() {
        return prix;
    }


    //updat station de depart
    public void setStationDepart(Station stationDepart) {
        this.stationDepart = stationDepart;
        this.dateDebutTrajet = new Date();

    }
    //updat station d'arriver
    public void setStationArrive(Station stationArrive) {
        this.stationArrive = stationArrive;
        this.dateFinTrajet = new Date();
        calculDuree();
        calculPrixTrajet();
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

     //calculer le prix du trajet par heure selon le modele
    public void calculPrixTrajet() {
        this.prix = velo.modele.getCoutHoraire()*duree;

        // TODO implement here
    }

}
