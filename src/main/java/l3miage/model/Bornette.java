package l3miage.model;

import javax.persistence.*;

/**
 * 
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Bornette.findAll", query = "select b from Bornette b"),
        @NamedQuery(name = "Bornette.findByVeloOkByStationId", query = "select b from Bornette b where b.velo.etat = ok and b.station.id = :id"),
        @NamedQuery(name = "Bornette.retraitVelo", query = "update Bornette b set b.velo = NULL where b.id = :id")
})

public class Bornette {

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
    private Etat etat;

    /**
     * 
     */
    @OneToOne
    public Velo velo;

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

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Velo getVelo() {
        return velo;
    }

    public void setVelo(Velo velo) {
        this.velo = velo;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}