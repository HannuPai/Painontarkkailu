package painontarkkailu;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Luokka hallinnoi tietokantaa
 * 
 * @author Hannu Päiveröinen
 */
public class Rekisteri {
    
    private EntityManagerFactory emf = null;
    
    
    public Rekisteri(){
        // käytetään "PainontarkkailuPU"-konfiguraatiota
        emf = Persistence.createEntityManagerFactory("PainontarkkailuPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Palauttaa tietokannasta käyttäjät
     * @return käyttäjälista
     */
    public List<Kayttaja> getKayttajat(){
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Kayttaja.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
        }
    
    /**
     * Palauttaa tietokannasta harjoitteet
     * @return harjoitelistan
     */
    public List<Kayttaja> getHarjoitteet(){
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Harjoite.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
    /**
     * Etsii ja palauttaa käyttäjän käyttäjäId:n perusteella
     * @param lajiId Etsittävän käyttäjän ID-tunnus
     * @return Etsitty käyttäjä
     */
    public Kayttaja haeKayttaja(long kayttajaId) {
        EntityManager em = getEntityManager();
        return em.find(Kayttaja.class, kayttajaId);
    }
    
    /**
     * Lisää tietokantaan uuden käyttäjän
     * @param kayttaja lisättävä käyttäjä
     */
    public void lisaaKayttaja(Kayttaja kayttaja){
        EntityManager em = getEntityManager();
	// aloitetaan transaktio
        em.getTransaction().begin();
	// tallennetaan kayttaja
        em.merge(kayttaja);
	// lopetetaan transaktio sanomalla commit
        em.getTransaction().commit();
    }

    /**
     * Lisätään rekisteriin uusi harjoite
     * @param uusi Lisättävä harjoite
     */
    void lisaaHarjoite(Harjoite uusi) {
        EntityManager em = getEntityManager();
	// aloitetaan transaktio
        em.getTransaction().begin();
	// tallennetaan harjoite
        em.merge(uusi);
	// lopetetaan transaktio sanomalla commit
        em.getTransaction().commit();
    }

    /**
     * Lisätään rekisteriin uusi laji
     * @param uusi Lisättävä laji
     */
    void lisaaLaji(Laji uusi) {
        EntityManager em = getEntityManager();
	// aloitetaan transaktio
        em.getTransaction().begin();
	// tallennetaan laji
        em.merge(uusi);
	// lopetetaan transaktio sanomalla commit
        em.getTransaction().commit();
    }

    /**
     * Palauttaa tietokannasta lajit
     * @return lajit
     */
    Object getLajit() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Laji.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }

    /**
     * Etsii ja palauttaa lajin lajiId:n perusteella
     * @param lajiId Etsittävän lajin ID-tunnus
     * @return Etsitty laji
     */
    Laji haeLaji(long lajiId) {
        EntityManager em = getEntityManager();
        return em.find(Laji.class, lajiId);
    }

     /**
     * Palauttaa tietokannasta ruoat
     * @return ruoat
     */
    Object getRuoat() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Ruoka.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
    /**
     * Etsii ja palauttaa ruoan ruokaId:n perusteella
     * @param ruokaId Etsittävän ruoan ID-tunnus
     * @return Etsitty ruoka
     */
    Ruoka haeRuoka(long ruokaId) {
        EntityManager em = getEntityManager();
        return em.find(Ruoka.class, ruokaId);
    }

    /**
     * Palauttaa tietokannasta ruokaliitokset
     * @return ruokaliitokset
     */
    
    Object getRuokaliitokset() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Ruokaliitos.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
    /**
     * Palauttaa tietokannasta raaka-aineet
     * @return raaka-aineet
     */
    Object getRaakaaineet() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(RaakaAine.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
    /**
     * Etsii ja palauttaa raakaaineen raakaaineId:n perusteella
     * @param raakaaineId Etsittävän raakaaineen ID-tunnus
     * @return Etsitty raakaaine
     */
    RaakaAine haeRaakaaine(long raakaaineId) {
        EntityManager em = getEntityManager();
        return em.find(RaakaAine.class, raakaaineId);
    }

    /**
     * Lisää tietokantaan uuden raaka-aineen
     * @param uusi lisättävä raaka-aine
     */
    void lisaaRaakaAine(RaakaAine uusi) {
        EntityManager em = getEntityManager();
	// aloitetaan transaktio
        em.getTransaction().begin();
	// tallennetaan raaka-aine
        em.merge(uusi);
	// lopetetaan transaktio sanomalla commit
        em.getTransaction().commit();
    }

    /**
     * Lisää tietokantaan ruokaliitoksen
     * @param ruokaliitos lisättävä ruokaliitos
     */
    void lisaaRuokaliitos(Ruokaliitos ruokaliitos) {
        EntityManager em = getEntityManager();
	// aloitetaan transaktio
        em.getTransaction().begin();
	// tallennetaan ruokaliitos
        em.merge(ruokaliitos);
	// lopetetaan transaktio sanomalla commit
        em.getTransaction().commit();
    }

    /**
     * Lisää tietokantaan ruoan
     * @param ruokaliitos lisättävä ruoka
     */
    void lisaaRuoka(Ruoka ruoka) {
        EntityManager em = getEntityManager();
	// aloitetaan transaktio
        em.getTransaction().begin();
	// tallennetaan ruoka
        em.merge(ruoka);
	// lopetetaan transaktio sanomalla commit
        em.getTransaction().commit();
    }

}
