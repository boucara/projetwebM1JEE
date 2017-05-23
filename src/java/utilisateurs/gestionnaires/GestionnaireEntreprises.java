/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaires;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utilisateurs.modeles.Entreprise;

/**
 *
 * @author Tom
 */
@Stateless
public class GestionnaireEntreprises {

    @PersistenceContext  
    private EntityManager em;
    
    public Entreprise insererEntreprise(String nom, String prenom, String email, String mdp) {
        return null;
    }

    public Entreprise metreajourEntreprise(String email, String nom, String prenom, String mdp) {
        return null;
    }

    public void supprimerEntreprise(String email) {
    }

    public Entreprise selectEntreprise(String email, String pwd) {
        return null;
    }

    public ArrayList<Entreprise> selectEntreprises(int pagination) {
        return null;
    }

    public ArrayList<Entreprise> selectEntreprises(String email, String nom, String prenom, int pagination) {
        return null;
    }

    public int nombreEntreprises() {
        return 0;
    }
    
    public int nombreEntreprises(String email, String nom, String prenom) {
        return 0;
    }
}
