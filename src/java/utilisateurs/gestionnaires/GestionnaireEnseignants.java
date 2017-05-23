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
import utilisateurs.modeles.Enseignant;

/**
 *
 * @author Tom
 */
@Stateless
public class GestionnaireEnseignants {

    @PersistenceContext  
    private EntityManager em;

    public void insererEnseignant(Enseignant e) { 
        em.persist(e);  
    }

    public Enseignant metreajourEnseignant(String email, String nom, String prenom, String mdp) {
        return null;
    }

    public void supprimerEnseignant(String email) {
    }

    public Enseignant selectEnseignant(String email, String pwd) {
        return null;
    }

    public Collection<Enseignant> selectEnseignants(int pagination) {
        return null;
    }

    public Collection<Enseignant> selectEnseignants(String email, String nom, String prenom, int pagination) {
        return null;
    }

    public int nombreEnseignants() {
        return 0;
    }
    
    public int nombreEnseignants(String email, String nom, String prenom) {
        return 0;
    }
}
