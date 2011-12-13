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
public class Ruokaliitos  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private RaakaAine raakaaine;
    private double maara;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private Ruoka ruoka;

    public Ruokaliitos() {
    }


    public Ruokaliitos(RaakaAine raakaaine, double maara, Ruoka ruoka) {
        this.maara = maara;
        this.raakaaine = raakaaine;
        this.ruoka = ruoka;
    }

    public RaakaAine getRaakaaine() {
        return raakaaine;
    }

    public void setRaakaaine(RaakaAine raakaaine) {
        this.raakaaine = raakaaine;
    }

    public Ruoka getRuoka() {
        return ruoka;
    }

    public void setRuoka(Ruoka ruoka) {
        this.ruoka = ruoka;
    }

    public Ruokaliitos(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
