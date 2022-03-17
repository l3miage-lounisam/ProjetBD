package l3miage.model;

import javax.persistence.*;
import java.util.*;

/**
 * 
 */
@Entity
public class Velo {

    /**
     * Default constructor
     */
    public Velo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 
     */
    private Date dateMiseService;

    /**
     * 
     */
    private Etat etat;

    /**
     * 
     */
    private String puce;

    /**
     * 
     */

    @ManyToOne
    @JoinColumn(name = "bornette_id")
    public Bornette bornette;

    /**
     * 
     */
    @ManyToOne
    public Modele modele;

    /**
     * 
     */
    public Set<Trajet> trajets;

    public Bornette getBornette() {
        return bornette;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateMiseService() {
        return dateMiseService;
    }

    public void setDateMiseService(Date dateMiseService) {
        this.dateMiseService = dateMiseService;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public String getPuce() {
        return puce;
    }

    public void setPuce(String puce) {
        this.puce = puce;
    }

    public void setBornette(Bornette bornette) {
        this.bornette = bornette;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public Set<Trajet> getTrajets() {
        return trajets;
    }

    public void setTrajets(Set<Trajet> trajets) {
        this.trajets = trajets;
    }
}