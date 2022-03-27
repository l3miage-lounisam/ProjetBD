package l3miage.model;

import javax.persistence.*;

/**
 * Creation d'une classe bornette qui défini l'etat de la bornette, elle est identifier par  un etat("ok" ou "hs")
 * une bornette se trouve dans une station et contient 0 ou 1 velo 
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


    //le mapping 

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

    //L'identifaint de la bornette
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //l'etat de la bornette de type etat
    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    //Renvoi le velo qui se trouve a la bornette 
    public Velo getVelo() {
        return velo;
    }

    public void setVelo(Velo velo) {
        this.velo = velo;
        if(velo!=null)
         velo.setBornette(this);
    }

    //
    public void removeVelo(){
        if(velo!=null){
            this.velo.setBornette(null);
            this.setVelo(null);
        }
    }

    //Station posseadant la bornette 
    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
