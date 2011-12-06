/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painontarkkailu;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Hannu Päiveröinen
 */
public class Rekisteri {
    
    private EntityManagerFactory emf = null;
    
  //  private static List<Kayttaja> kayttajat = new ArrayList();
    
    public Rekisteri(){
        // käytetään "PainontarkkailuPU"-konfiguraatiota
        emf = Persistence.createEntityManagerFactory("PainontarkkailuPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Kayttaja> getKayttajat(){
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Kayttaja.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
        }
    
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

    void lisaaRaakaAine(RaakaAine uusi) {
        EntityManager em = getEntityManager();

	// aloitetaan transaktio
        em.getTransaction().begin();
	// tallennetaan raaka-aine
        em.merge(uusi);
	// lopetetaan transaktio sanomalla commit
        em.getTransaction().commit();
    }
}
