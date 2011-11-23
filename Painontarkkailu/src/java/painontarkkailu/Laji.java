/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painontarkkailu;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author Hannu Päiveröinen
 */

@Entity
public class Laji implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nimi;
    @Column
    private double kulutus;

    @OneToMany
    @JoinTable(joinColumns = {
        @JoinColumn(name = "laji_id")},
    inverseJoinColumns = {
        @JoinColumn(name = "harjoite_id")})
    private List<Harjoite> harjoitteet;

    public Laji() {
    }

    public Laji(String nimi, double kulutus) {
        this.nimi = nimi;
        this.kulutus = kulutus;
    }

    public List<Harjoite> getHarjoitteet() {
        return harjoitteet;
    }

    public void setHarjoitteet(List<Harjoite> harjoitteet) {
        this.harjoitteet = harjoitteet;
    }

    public double getKulutus() {
        return kulutus;
    }

    public void setKulutus(double kulutus) {
        this.kulutus = kulutus;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    
}
