package Projet;

import javax.persistence.*;

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
    }

    /**
     * 
     */
    @Column(nullable = false)
    private Integer numeroCB;

    /**
     * 
     */
    @Column(nullable = false)
    private String codeSecret;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroCB() {
        return numeroCB;
    }

    public void setNumeroCB(Integer numeroCB) {
        this.numeroCB = numeroCB;
    }

    public String getCodeSecret() {
        return codeSecret;
    }

    public void setCodeSecret(String codeSecret) {
        this.codeSecret = codeSecret;
    }
}