package l3miage.model;

import javax.persistence.*;
import java.util.*;

/**
 * 
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Station.findAll", query = "select s from Station s")
})
public class Station {

    /**
     * Default constructor
     */
    public Station() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 
     */
    private String adresse;

    /**
     * 
     */
    @OneToMany
    public List<Bornette> bornettes;

    /**
     * 
     */


    /**
     * 
     */

    /**
     * 
     */
    @OneToMany
    public List<DefinitionStation> definitions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Bornette> getBornettes() {
        return bornettes;
    }

    public void setBornettes(List<Bornette> bornettes) {
        this.bornettes = bornettes;
    }

    public List<DefinitionStation> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<DefinitionStation> definitions) {
        this.definitions = definitions;
    }

    /**
     * @return
     */

    public String getAdresse() {
        // TODO implement here
         return  this.adresse;
    }

}