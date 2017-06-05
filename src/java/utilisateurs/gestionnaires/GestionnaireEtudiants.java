/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaires;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Etudiant;

/**
 *
 * @author Tom
 */
@Stateless
public class GestionnaireEtudiants {

    @PersistenceContext
    private EntityManager em;

    public Etudiant insererEtudiant(Etudiant e) {
        em.persist(e);
        return e;
    }
    
    public Etudiant selectEtudiant(String email) {
        Query q = em.createQuery("select e from Etudiant e where e.email='"+email+"'");
        if(!q.getResultList().isEmpty()) {
            return (Etudiant)q.getResultList().get(0);
        }
        else {
            return null;
        }
    }
    
    public Etudiant selectEtudiant(String email, String mdp) {
        Query q = em.createQuery("select e from Etudiant e where e.email='"+email+"' and e.mdp='"+mdp+"'");
        if(!q.getResultList().isEmpty()) {
            return (Etudiant)q.getResultList().get(0);
        }
        else {
            return null;
        }
    }

    public void modifEtudiant(String nom, String prenom, String login, String mdp) {

        Query q = em.createQuery("update Etudiant e set e.nom= :nom  , e.prenom=:prenom ,e.email=:email  , e.mdp=:mdp  where  e.email=:email ");
        q.setParameter("nom", nom);
        q.setParameter("prenom", prenom);
        q.setParameter("login", login);
        q.setParameter("mdp", mdp);
        int numUpdates = q.executeUpdate();
    }
    public void deleteEtudiant (String email ,String nom, String prenom, String mdp){
        Query q= em.createQuery("delete from Etudiant e where e.email=:email  "); 
            q.setParameter("email", email);
            int numUpdates = q.executeUpdate();
        
    }
    

    public Collection<Etudiant> getAllUsers() {
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select e from Etudiant e");
        return q.getResultList();
    }

}
