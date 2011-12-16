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
 * Luokka sisältää Harjoite taulun konstruktiot sekä getterit ja setterit
 * @author Hannu Päiveröinen
 */
@Entity
public class Harjoite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String paivays;
    @Column
    private double kestoMinuuteissa;
    @Column
    private String kommentti;
    @Column
    private int syke;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private Kayttaja kayttaja;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private Laji laji;

    public Harjoite() {
    }

    Harjoite(Kayttaja kayttaja, Laji laji, String paivays, double kestoMinuuteissa, String kommentti, int syke) {
        this.kayttaja = kayttaja;
        this.laji = laji;
        this.paivays = paivays;
        this.kestoMinuuteissa = kestoMinuuteissa;
        this.kommentti = kommentti;
        this.syke = syke;
    }

    public Kayttaja getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
        if (!kayttaja.getHarjoitteet().contains(this)) {
            kayttaja.getHarjoitteet().add(this);
        }
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

    public String getPaivays() {
        return paivays;
    }

    public void setPaivays(String paivays) {
        this.paivays = paivays;
    }

    public int getSyke() {
        return syke;
    }

    public void setSyke(int syke) {
        this.syke = syke;
    }
}
