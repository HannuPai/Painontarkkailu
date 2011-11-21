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
        //return em.createQuery("SELECT k FROM Kayttaja k").getResultList();
    }
    public List<Kayttaja> getHarjoitteet(){
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Harjoite.class));
        Query q = em.createQuery(cq);

        return q.getResultList();
    }
    
    public Kayttaja haeKayttaja(long kayttajaId) {
        EntityManager em = getEntityManager();
        return em.find(Kayttaja.class, kayttajaId);
    }
    
    public void lisaaKayttaja(Kayttaja kayttaja){
        EntityManager em = getEntityManager();

	// aloitetaan transaktio
        em.getTransaction().begin();
	// tallennetaan kayttaja
        em.persist(kayttaja);
	// lopetetaan transaktio sanomalla commit
        em.getTransaction().commit();
    }

    void lisaaHarjoite(Harjoite uusi) {
        EntityManager em = getEntityManager();

	// aloitetaan transaktio
        em.getTransaction().begin();
	// tallennetaan harjoite
        em.persist(uusi);
	// lopetetaan transaktio sanomalla commit
        em.getTransaction().commit();
    }
    
}
