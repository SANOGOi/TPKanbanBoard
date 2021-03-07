package jpa;

import dao.UtilisateurDAO;
import domain.*;

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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {

            Utilisateur usr1 = new Utilisateur();
            usr1.setSpeudo("isanogo");
            usr1.setPoste("Ing Dev");
            /*Utilisateur usr2 = new Utilisateur();
            usr2.setSpeudo("vsanogo");
            usr2.setPoste("Ing Dev");*/

            Kanban kb = new Kanban();
            kb.setTitreProjet("Projet1");

            Section sec1 = new Section();
            //Section sec2 = new Section();
            //Section sec3 = new Section();
            sec1.setState("En attente");
            sec1.setKanban(kb);
            kb.addSection(sec1);
            //sec2.setState("En Cours");
            //sec3.setState("Réalisé");

            Fiche f1 = new Fiche();
            f1.setLibelle("Fiche1");
            f1.setDateButoire(new SimpleDateFormat("dd-MM-yy").parse("29-01-2021"));
            f1.setLieu("Rennes");
            f1.setUrl("tache1.com");
            f1.setNote("blabla...");
            f1.setUtilisateur(usr1);
            f1.setSection(sec1);



            Tags t1 = new Tags();
            t1.setLibelle("Facile");
            t1.setFiche(f1);
            f1.addTags(t1);

            /*Tags t2 = new Tags();
            t2.setLibelle("Difficile");
            Tags t3 = new Tags();
            t3.setLibelle("Moyen");*/



            /*Fiche f2 = new Fiche();
            f2.setLibelle("Fiche2");
            f2.setDateButoire(new SimpleDateFormat("dd-MM-yy").parse("29-01-2021"));
            f2.setLieu("Rennes");
            f2.setUrl("tache2.com");
            f2.setNote("blabla...");*/

            manager.persist(usr1);
            manager.persist(kb);
            manager.persist(sec1);
            manager.persist(f1);
            manager.persist(t1);
            //manager.persist(sec1);
            //manager.persist(f1);
            //manager.persist(t1);

            /*Utilisateur user = new Utilisateur("SANOGO", "Issa", new SimpleDateFormat("dd-MM-yy").parse("21-12-1993"), "Dev");
            UtilisateurDAO dao = new UtilisateurDAO();
            dao.saveUser(user1);*/

            tx.commit();


        } catch (Exception e) {
            e.printStackTrace();
        }


        manager.close();
        factory.close();
    }

}
