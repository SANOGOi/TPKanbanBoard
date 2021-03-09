package dao;

import domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class FicheDAO {

    private EntityManager em;

    public FicheDAO(EntityManager manager) {
        this.em = manager;
    }

    public void saveInDB(Fiche fiche) {
        EntityTransaction tx = this.em.getTransaction();
        tx.begin();
        this.em.persist(fiche);
        tx.commit();
    }

    public List<Fiche> fetchFiche() {
        //JPQL = faire des query et exec sur l'em avec la méthode createQuerry()
        String req = "select f from Fiche as f";
        Query query = this.em.createQuery(req);
        return query.getResultList();
    }

    public List<Fiche> getFicheByLibelle(String lib) {
        Query query = this.em.createNamedQuery("findFicheByLibelle", Fiche.class);
        query.setParameter("lib", lib);
        return query.getResultList();
    }
}
