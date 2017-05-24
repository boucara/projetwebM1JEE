/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaires;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Aicha
 */
@Entity
public class GestionnaireUtilisateur implements Serializable {
    @PersistenceContext
    private EntityManager em;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestionnaireUtilisateur)) {
            return false;
        }
        GestionnaireUtilisateur other = (GestionnaireUtilisateur) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
   public Utilisateur getUser(String login, String mdp) {
        Query q = em.createQuery("select u from Utilisateur u where u.mdp='"+mdp+"' and u.login='"+login+"'");
        if(!q.getResultList().isEmpty()) {
            return (Utilisateur)q.getResultList().get(0);
        }
        else {
            return null;
        }
    }
    

    @Override
    public String toString() {
        return "utilisateurs.gestionnaires.GestionnaireUtilisateur[ id=" + id + " ]";
    }
    
}
