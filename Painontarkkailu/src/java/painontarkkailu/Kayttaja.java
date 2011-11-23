/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Hannu Päiveröinen
 */
@Entity
public class Kayttaja implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String kayttajanimi;
    @Column
    private String nimi;
    @Column
    private int ika;
    @Column
    private String sukupuoli;
    @Column
    private int pituus;
    @Column
    private double paino;
    
    @OneToMany
    @JoinTable(joinColumns = {
        @JoinColumn(name = "kayttaja_id")},
    inverseJoinColumns = {
        @JoinColumn(name = "harjoite_id")})
    private List<Harjoite> harjoitteet;
    
    public Kayttaja() {
    }
    
    public Kayttaja(String kayttajanimi, String nimi, int ika, String sukupuoli, int pituus, double paino){
        this.kayttajanimi = kayttajanimi;
        this.nimi = nimi;
        this.ika = ika;
        this.sukupuoli = sukupuoli;
        this.pituus = pituus;
        this.paino = paino;
    }

    public List<Harjoite> getHarjoitteet() {
        return harjoitteet;
    }

    public void setHarjoitteet(List<Harjoite> harjoitteet) {
        this.harjoitteet = harjoitteet;
    }
    
    public long getId() {
        return id;
    }
    
    public String getKayttajanimi(){
        return kayttajanimi;
    }

    public String getNimi(){
        return nimi;
    }
    
    public int getIka(){
        return ika;
    }
    
    public String getSukupuoli(){
        return sukupuoli;
    }
    
    public int getPituus(){
        return pituus;
    }
    
    public double getPaino(){
        return paino;
    }
}
