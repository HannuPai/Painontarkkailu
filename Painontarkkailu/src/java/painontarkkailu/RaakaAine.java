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
public class RaakaAine  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nimi;
    @Column
    private double energia;

    @OneToMany
    @JoinTable(joinColumns = {
        @JoinColumn(name = "raakaaine_id")},
    inverseJoinColumns = {
        @JoinColumn(name = "ruokaliitos_id")})
    private List<Ruokaliitos> ruokaliitokset;
    
    public RaakaAine() {
    }

    public RaakaAine(String nimi, double energia) {
        this.nimi = nimi;
        this.energia = energia;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
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
