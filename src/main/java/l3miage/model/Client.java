package l3miage.model;

import javax.persistence.*;
import java.util.Random;

/**
 * 
 */
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

    public Long getNumeroCB() {
        return numeroCB;
    }

    public void setNumeroCB(Long numeroCB) {
        this.numeroCB = numeroCB;
    }

    public Integer getCodeSecret() {
        return codeSecret;
    }

    public void setCodeSecret(Integer codeSecret) {
        this.codeSecret = codeSecret;
    }
}