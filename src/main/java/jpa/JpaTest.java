package jpa;

import dao.UtilisateurDAO;
import domain.Fiche;
import domain.Section;
import domain.Tags;
import domain.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JpaTest {

    private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            Section section1 = new Section("En attente");
            Section section2 = new Section("En cours");
            Section section3 = new Section("Réalisé");

            Tags t1 = new Tags("Facile");
            Tags t2 = new Tags("Difficile");
            Tags t3 = new Tags("Moyen");

            Utilisateur user1 = new Utilisateur("SANOGO", "Vamara", new SimpleDateFormat("dd-MM-yy").parse("00-00-1900"), "Ing Dev");
            Utilisateur user2 = new Utilisateur("SANOGO", "Daouda", new SimpleDateFormat("dd-MM-yy").parse("00-00-1900"), "Ing Dev");

            Fiche f1 = new Fiche("Fiche1", new SimpleDateFormat("dd-MM-yy").parse("29-01-2021"), "Rennes", "tache1.com", "ok");
            Fiche f2 = new Fiche("Fiche2", new SimpleDateFormat("dd-MM-yy").parse("29-01-2021"), "Rennes", "tache2.com", "ok");
            Fiche f3 = new Fiche("Fiche3", new SimpleDateFormat("dd-MM-yy").parse("29-01-2021"), "Rennes", "tache3.com", "ok");

            List<Tags> tags1 = new ArrayList<Tags>();
            List<Tags> tags2 = new ArrayList<Tags>();
            List<Fiche> fiches1 = new ArrayList<Fiche>();
            List<Fiche> fiches2 = new ArrayList<Fiche>();

            tags1.add(t1);
            tags1.add(t2);
            tags2.add(t3);
            fiches1.add(f1);
            fiches1.add(f2);
            fiches2.add(f3);

            user1.setFiches(fiches1);
            user2.setFiches(fiches2);
            section1.setFiches(fiches2);
            section2.setFiches(fiches1);
            section3.setFiches(fiches2);
            f1.setTags(tags2);
            f2.setTags(tags1);
            f3.setTags(tags1);

            manager.persist(section1);
            manager.persist(section2);
            manager.persist(section3);
            manager.persist(t1);
            manager.persist(t2);
            manager.persist(t3);
            manager.persist(user1);
            manager.persist(user2);
            manager.persist(f1);
            manager.persist(f2);
            manager.persist(f3);

            /*Utilisateur user = new Utilisateur("SANOGO", "Issa", new SimpleDateFormat("dd-MM-yy").parse("21-12-1993"), "Dev");
            UtilisateurDAO dao = new UtilisateurDAO();
            dao.saveUser(user1);*/


        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        factory.close();
    }

}

