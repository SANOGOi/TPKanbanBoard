package dao;

import domain.Utilisateur;
import jpa.EntityManagerHelper;

import javax.persistence.EntityTransaction;

public class UtilisateurDAO {

    public void saveUser(Utilisateur user) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();

        t.begin();
        EntityManagerHelper.getEntityManager().persist(user);
        t.commit();
    }
}
