package l3miage.model;

import javax.persistence.*;

/**
 * 
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Bornette.findAll", query = "select b from Bornette b"),
        @NamedQuery(name = "Bornette.findByVeloOkByStationId", query = "select b from Bornette b where b.velo.etat = :etat and b.station.id = :id"),
        @NamedQuery(name = "Bornette.retraitVelo", query = "update Bornette b set b.velo = NULL where b.id = :id"),
        @NamedQuery(name = "Bornette.renduVelo", query = "update Bornette b set b.velo.id = :idvelo where b.id = :idbornette"),
        @NamedQuery(name = "Bornette.findBornetteVideByStationId", query = "select b from Bornette b where b.station.id = :id and b.velo.id is NULL")
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
        if(velo!=null)
         velo.setBornette(this);
    }
    public void removeVelo(){
        if(velo!=null){
            this.velo.setBornette(null);
            this.setVelo(null);
        }
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}