package jpa;

import dao.FicheDAO;
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
        //Q4: Connexion à mysql
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        //Pour les questions Q1 et Q2 veillez de-commenter cette partie de code
        /*EntityTransaction tx = manager.getTransaction();
        tx.begin();*/
        try {
            //Q1-Q2
            /*Utilisateur usr1 = new Utilisateur();
            usr1.setSpeudo("isanogo");
            usr1.setPoste("Ing Dev");
            Utilisateur usr2 = new Utilisateur();
            usr2.setSpeudo("vsanogo");
            usr2.setPoste("Ing Dev");

            Kanban kb = new Kanban();
            kb.setTitreProjet("Projet1");

            Section sec1 = new Section();
            Section sec2 = new Section();
            Section sec3 = new Section();
            sec1.setState("En attente");
            sec1.setKanban(kb);
            kb.addSection(sec1);
            sec2.setState("En cours");
            sec2.setKanban(kb);
            kb.addSection(sec2);
            sec3.setState("Réalisé");
            sec3.setKanban(kb);
            kb.addSection(sec3);

            Fiche f1 = new Fiche();
            f1.setLibelle("Fiche1");
            f1.setDateButoire(new SimpleDateFormat("dd-MM-yy").parse("29-01-2021"));
            f1.setLieu("Rennes");
            f1.setUrl("tache1.com");
            f1.setNote("blabla...");
            f1.setUtilisateur(usr1);
            f1.setSection(sec1);
            Fiche f2 = new Fiche();
            f2.setLibelle("Fiche2");
            f2.setDateButoire(new SimpleDateFormat("dd-MM-yy").parse("29-01-2021"));
            f2.setLieu("Rennes");
            f2.setUrl("tache2.com");
            f2.setNote("blabla...");
            f2.setUtilisateur(usr2);
            f2.setSection(sec2);


            Tags t1 = new Tags();
            t1.setLibelle("Facile");
            t1.setFiche(f1);
            f1.addTags(t1);

            Tags t2 = new Tags();
            t2.setLibelle("A revoir");
            t2.setFiche(f1);
            f1.addTags(t2);

            manager.persist(usr1);
            manager.persist(usr2);
            manager.persist(kb);
            manager.persist(sec1);
            manager.persist(sec2);
            manager.persist(sec3);
            manager.persist(f1);
            manager.persist(f2);
            manager.persist(t1);
            manager.persist(t2);

            tx.commit();*/

            //Q3
            FicheDAO ficheDAO = new FicheDAO(manager);
            Fiche f = new Fiche();
            f.setLibelle("Fiche3");
            Section s1 = new Section();
            s1.setState("En cours");
            Kanban tab = new Kanban();
            tab.setTitreProjet("Projet JPA");
            s1.setKanban(tab);
            f.setSection(s1);
            //create user which will work on this fiche
            Utilisateur us1 = new Utilisateur();
            us1.setSpeudo("Oklin");
            us1.setPoste("Ing Dev");
            //add user to this fiche
            us1.addFiches(f);
            //saved all objects linked to c in db
            ficheDAO.saveInDB(f);

            //get  all fiche from database
            List<Fiche> res = ficheDAO.fetchFiche();
            for(Fiche fiche : res) {
                System.out.println(fiche.getId() + "    "+ fiche.getLibelle() + "   " + fiche.getUtilisateur().getSpeudo()) ;
            }

            //get fiche by it's libelle
            Fiche ficheByLib = ficheDAO.getFicheByLibelle("Fiche3").get(0);
            System.out.println("Fiche retrieved by libelle \n" + ficheByLib.getId() + "--" + ficheByLib.getLibelle());


        } catch (Exception e) {
            e.printStackTrace();
        }

        manager.close();
        factory.close();
    }

}
