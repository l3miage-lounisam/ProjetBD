package l3miage.model;

import javax.persistence.*;

/**
 * 
 */
@Entity
public class DefinitionStation {

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
    public Integer heure;

    /**
     * 
     */
    public Definition defStation;

    /**
     * 
     */
    @ManyToOne
    public Station station;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHeure() {
        return heure;
    }

    public void setHeure(Integer heure) {
        this.heure = heure;
    }

    public Definition getDefStation() {
        return defStation;
    }

    public void setDefStation(Definition defStation) {
        this.defStation = defStation;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}