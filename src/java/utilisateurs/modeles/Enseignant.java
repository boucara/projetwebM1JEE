/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.modeles;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Tom
 */
@Entity
public class Enseignant extends Utilisateur implements Serializable {    

    public Enseignant() {
    }

    public Enseignant(String nom, String prenom, String mdp, String email) {
        setEmail(email);
        setMdp(mdp);
        setNom(nom);
        setPrenom(prenom);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) getId();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if (getId() != other.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Enseignant[ id=" + getId() + " ]";
    }
    
}
