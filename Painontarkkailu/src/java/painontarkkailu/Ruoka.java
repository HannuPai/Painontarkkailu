/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painontarkkailu;

/**
 *
 * @author Hannu Päiveröinen
 */
public class Ruoka {
    private long id;
    private String nimi;
    private double maara;

    public Ruoka() {
    }

    public Ruoka(long id, String nimi, double maara) {
        this.id = id;
        this.nimi = nimi;
        this.maara = maara;
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
