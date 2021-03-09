package dao;

import domain.Kanban;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class TabloDAO {
    private EntityManager em;

    public TabloDAO(EntityManager manager) {
        this.em = manager;
    }

    public void saveInDB(Kanban tab) {
        EntityTransaction tx = this.em.getTransaction();
        tx.begin();
        this.em.persist(tab);
        tx.commit();
    }

    public List<Kanban> fetchTablo() {
        String req = "select t from Tablo as t";
        Query query = this.em.createQuery(req);
        return query.getResultList();
    }
}
