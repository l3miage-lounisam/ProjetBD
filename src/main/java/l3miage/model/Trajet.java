package l3miage.model;

import javax.persistence.*;
import java.util.*;

/**
 * 
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

    public void calculDuree(){
       this.duree = Math.toIntExact((dateFinTrajet.getTime() - dateDebutTrajet.getTime()) /1000 );
    }


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


    public Float getPrix() {
        return prix;
    }


    public void setStationDepart(Station stationDepart) {
        this.stationDepart = stationDepart;
        this.dateDebutTrajet = new Date();

    }

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

    public void calculPrixTrajet() {
        this.prix = velo.modele.getCoutHoraire()*duree;

        // TODO implement here
    }

}