package l3miage.model;

import javax.persistence.*;
import java.util.Random;

/**
 * création de la classe client, la classe mére des classes: les abonneé et les nonAbonne,
 * chaque client(abonné ou NonAbonne) possede un numéroCB et un CodeSecret qui lui permetra de s'identifier
 * 
 */

//mapping
@Inheritance(strategy= InheritanceType.JOINED)
@Entity
@DiscriminatorColumn(name="type")
public abstract class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Default constructor
     */
    public Client() {
        Random r = new Random();
        setCodeSecret(r.nextInt(10000));
    }

    /**
     * 
     */
    @Column(nullable = false)
    private Long numeroCB;

    /**
     * 
     */
    @Column(nullable = false)
    private Integer codeSecret;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //le numéro de carte bancaire d'un client
    public Long getNumeroCB() {
        return numeroCB;
    }

    public void setNumeroCB(Long numeroCB) {
        this.numeroCB = numeroCB;
    }

    //le code secret d'un client 
    public Integer getCodeSecret() {
        return codeSecret;
    }

    public void setCodeSecret(Integer codeSecret) {
        this.codeSecret = codeSecret;
    }
}
