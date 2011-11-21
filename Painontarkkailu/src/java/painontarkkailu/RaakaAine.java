/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painontarkkailu;

/**
 *
 * @author Hannu Päiveröinen
 */
public class RaakaAine {
    private long id;
    private String nimi;
    private String tyyppi;
    private double energia;

    public RaakaAine() {
    }

    public RaakaAine(long id, String nimi, String tyyppi, double energia) {
        this.id = id;
        this.nimi = nimi;
        this.tyyppi = tyyppi;
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

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }
    
}
