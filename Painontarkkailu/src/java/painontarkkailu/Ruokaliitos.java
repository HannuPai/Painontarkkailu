/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painontarkkailu;

/**
 *
 * @author Hannu Päiveröinen
 */
public class Ruokaliitos {
    private long id;
    //TODO: JoinColumns Raakaaine&Ruoka

    public Ruokaliitos() {
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
