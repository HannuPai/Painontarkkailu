package painontarkkailu;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 * Ruoka-luokka hallinnoi ruoan konstruktoreita ja getterit sekä setterit
 * @author Hannu Päiveröinen
 */
@Entity
public class Ruoka {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nimi;
    @Column
    private double maara;

    @OneToMany
    @JoinTable(joinColumns = {
        @JoinColumn(name = "ruoka_id")},
    inverseJoinColumns = {
        @JoinColumn(name = "ruokaliitos_id")})
    private List<Ruokaliitos> ruokaliitokset;
    
    public Ruoka() {
    }

    public Ruoka(String nimi) {
        this.nimi = nimi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMaara() {
        return maara;
    }

    public void setMaara(double maara) {
        this.maara = maara;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }   
}
