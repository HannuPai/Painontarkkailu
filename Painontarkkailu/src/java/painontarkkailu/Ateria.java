/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painontarkkailu;

/**
 *
 * @author Hannu Päiveröinen
 */
public class Ateria {
    private long id;
    private String date;
    //TODO: JoinColumns käyttäjä&ruoka

    public Ateria() {
    }

    public Ateria(long id, String date) {
        this.id = id;
        this.date = date;
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
