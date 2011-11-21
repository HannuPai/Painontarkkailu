/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painontarkkailu;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 *
 * @author Hannu Päiveröinen
 */
@Entity
public class Harjoite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private Timestamp paivays;
    @Column
    private double kestoMinuuteissa;
    @Column
    private String saa;
    @Column
    private String kommentti;
    @Column
    private int syke;

    @JoinColumn
    private Kayttaja kayttaja;

    public Kayttaja getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getKestoMinuuteissa() {
        return kestoMinuuteissa;
    }

    public void setKestoMinuuteissa(double kestoMinuuteissa) {
        this.kestoMinuuteissa = kestoMinuuteissa;
    }

    public String getKommentti() {
        return kommentti;
    }

    public void setKommentti(String kommentti) {
        this.kommentti = kommentti;
    }

    public Timestamp getPaivays() {
        return paivays;
    }

    public void setPaivays(Timestamp paivays) {
        this.paivays = paivays;
    }

    public String getSaa() {
        return saa;
    }

    public void setSaa(String saa) {
        this.saa = saa;
    }

    public int getSyke() {
        return syke;
    }

    public void setSyke(int syke) {
        this.syke = syke;
    }
}
