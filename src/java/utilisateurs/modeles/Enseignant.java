/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tom
 */
@Entity
public class Enseignant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private String mdp;
    private String email;

    public Enseignant() {
    }

    public Enseignant(String nom, String prenom, String mdp, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.email = email;
    }

    /**
     * Get the value of prenom
     *
     * @return the value of prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Set the value of prenom
     *
     * @param prenom new value of prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of mdp
     *
     * @return the value of mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Set the value of mdp
     *
     * @param mdp new value of mdp
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Enseignant[ id=" + id + " ]";
    }
    
}
