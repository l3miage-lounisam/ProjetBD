package l3miage.model;

import javax.persistence.*;
import java.util.*;

/**
 * creation de la classe Station, chaque station a un adress et une Definition(Vplus, Vmoins, Vnull)
 * une station possede 0 ou plusieurs bornettes
 */

 //Mapping
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

    //liste de bornette quue contien une station
    public List<Bornette> getBornettes() {
        return bornettes;
    }

    public void setBornettes(List<Bornette> bornettes) {
        this.bornettes = bornettes;
    }

    //liste de bornette quue contien une station
    public List<DefinitionStation> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<DefinitionStation> definitions) {
        this.definitions = definitions;
    }

    /**
     * @return
     */
    //l'adress d'une station
    public String getAdresse() {
        // TODO implement here
         return  this.adresse;
    }

}
