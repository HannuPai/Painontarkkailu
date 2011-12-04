/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painontarkkailu;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Hannu Päiveröinen
 */
@Entity
public class Ateria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String date;
    @Column
    private double maara;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private Kayttaja kayttaja;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private Ruoka ruoka;

    public Ateria() {
    }

    public Ateria(long id, String date, double maara) {
        this.id = id;
        this.date = date;
        this.maara = maara;
    }

    public Kayttaja getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    }

    public double getMaara() {
        return maara;
    }

    public void setMaara(double maara) {
        this.maara = maara;
    }

    public Ruoka getRuoka() {
        return ruoka;
    }

    public void setRuoka(Ruoka ruoka) {
        this.ruoka = ruoka;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
