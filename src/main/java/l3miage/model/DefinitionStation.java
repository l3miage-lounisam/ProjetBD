package l3miage.model;

import javax.persistence.*;

/**
 * creation de la classe DefinitionStation qui est defini par une heur pour
 * determiner si une station donné est Vplus ou Vmoins le cas du campus le matin qui est Vplus et le soir Vmoins, et par exemple
 * pendant les vacances Vnull
 * 
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "DefinitionStation.findAll", query = "select d from DefinitionStation d")
})

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

    //L'heure qui definit si la station est Vplus ou Vmoins ou Vnull
    public Integer getHeure() {
        return heure;
    }

    public void setHeure(Integer heure) {
        this.heure = heure;
    }

    //Deffinir une station 
    public Definition getDefStation() {
        return defStation;
    }

    public void setDefStation(Definition defStation) {
        this.defStation = defStation;
    }

    //station a définir
    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
