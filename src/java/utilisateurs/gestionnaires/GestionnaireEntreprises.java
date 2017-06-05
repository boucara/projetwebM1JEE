/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaires;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Entreprise;

/**
 *
 * @author Tom
 */
@Stateless
public class GestionnaireEntreprises {

    @PersistenceContext  
    private EntityManager em;
    
    public void insererEntreprise(Entreprise e) {  
        em.persist(e);  
    }

    public Entreprise metreajourEntreprise(String email, String nom, String prenom, String mdp, String fonction, String tel, String nomEntreprise, String adresseEntreprise, String secteurActiviteEntreprise) {
        return null;
    }

    public void supprimerEntreprise(String email) {
    }

    public Entreprise selectEntreprise(String email, String pwd) {
        Query q = em.createQuery("select e from Entreprise e where e.email='"+email+"' and e.mdp='"+pwd+"'");
        if(!q.getResultList().isEmpty()) {
            return (Entreprise)q.getResultList().get(0);
        }
        else {
            return null;
        }
    }
    
    public Entreprise selectEntreprise(String email) {
        Query q = em.createQuery("select e from Entreprise e where e.email='"+email+"'");
        if(!q.getResultList().isEmpty()) {
            return (Entreprise)q.getResultList().get(0);
        }
        else {
            return null;
        }
    }

    public Collection<Entreprise> selectEntreprises(int pagination) {
        return null;
    }

    public Collection<Entreprise> selectEntreprises(String email, String nom, String prenom, int pagination) {
        return null;
    }

    public int nombreEntreprises() {
        return 0;
    }
    
    public int nombreEntreprises(String email, String nom, String prenom) {
        return 0;
    }
}
