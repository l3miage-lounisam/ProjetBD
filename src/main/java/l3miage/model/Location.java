package l3miage.model;

import javax.persistence.*;
import java.util.*;

import static org.hibernate.internal.util.collections.CollectionHelper.isEmpty;

/**
 * 
 */
@NamedQueries({
        @NamedQuery(name = "Location.findAll", query = "select l from Location l"),
        @NamedQuery(name = "Location.findByNonAbonne_CodeSecretAndDureeLocIsNull", query = "select l from Location l where l.nonAbonne.codeSecret = :codeSecret and l.dureeLoc is null"),
        @NamedQuery(name = "Location.countByIdAndTrajets_StationArriveIsNull", query = "select count(trajets) from Location l inner join l.trajets trajets where l.id = :id and trajets.stationArrive is null"),
        @NamedQuery(name = "Location.findByAbonne_CodeSecretAndDureeLocIsNull", query = "select l from Location l where l.abonne.codeSecret = :codeSecret and l.dureeLoc is null")
})
@Entity
public class Location {

    /**
     * Default constructor
     */
    public Location() {
        this.trajets = new ArrayList<>();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    /**
     * 
     */
    private Integer dureeLoc;

    /**
     * 
     */
    private Float prix;

    /**
     * 
     */
    @OneToMany
    public List<Trajet> trajets;

    /**
     * 
     */
    @ManyToOne
    public Abonne abonne;

    /**
     * 
     */
    @ManyToOne
    public NonAbonne nonAbonne;

    public Abonne getAbonne() {
        return abonne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addTrajet(Trajet trajet){
        this.trajets.add(trajet);
    }
    /**
     * @return
     */
    public void calculPrix() {
        float sommePrix = 0;
        int sommeDuree = 0;
        if(!isEmpty(trajets)) {
            for (Trajet trajet : trajets) {
                sommePrix += trajet.getPrix();
                sommeDuree += trajet.getDuree();

            }
        }
        setPrix(sommePrix);
        setDureeLoc(sommeDuree);
    }

    public Integer getDureeLoc() {
        return dureeLoc;
    }

    public void setDureeLoc(Integer dureeLoc) {
        this.dureeLoc = dureeLoc;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public List<Trajet> getTrajets() {
        return trajets;
    }

    public void setTrajets(List<Trajet> trajets) {
        this.trajets = trajets;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public NonAbonne getNonAbonne() {
        return nonAbonne;
    }

    public void setNonAbonne(NonAbonne nonAbonne) {
        this.nonAbonne = nonAbonne;
    }
}