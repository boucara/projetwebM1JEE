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
public class Entreprise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private String mdp;
    private String email;
    private String fonction;
    private String tel;
    private String nomEntreprise;
    private String adresseEntreprise;
    private String secteurActiviteEntreprise;

    public Entreprise() {
    }

    public Entreprise(String nom, String prenom, String mdp, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.email = email;
    }

    /**
     * Get the value of secteurActiviteEntreprise
     *
     * @return the value of secteurActiviteEntreprise
     */
    public String getSecteurActiviteEntreprise() {
        return secteurActiviteEntreprise;
    }

    /**
     * Set the value of secteurActiviteEntreprise
     *
     * @param secteurActiviteEntreprise new value of secteurActiviteEntreprise
     */
    public void setSecteurActiviteEntreprise(String secteurActiviteEntreprise) {
        this.secteurActiviteEntreprise = secteurActiviteEntreprise;
    }


    /**
     * Get the value of adresseEntreprise
     *
     * @return the value of adresseEntreprise
     */
    public String getAdresseEntreprise() {
        return adresseEntreprise;
    }

    /**
     * Set the value of adresseEntreprise
     *
     * @param adresseEntreprise new value of adresseEntreprise
     */
    public void setAdresseEntreprise(String adresseEntreprise) {
        this.adresseEntreprise = adresseEntreprise;
    }


    /**
     * Get the value of nomEntreprise
     *
     * @return the value of nomEntreprise
     */
    public String getNomEntreprise() {
        return nomEntreprise;
    }

    /**
     * Set the value of nomEntreprise
     *
     * @param nomEntreprise new value of nomEntreprise
     */
    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }


    /**
     * Get the value of tel
     *
     * @return the value of tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Set the value of tel
     *
     * @param tel new value of tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }


    /**
     * Get the value of fonction
     *
     * @return the value of fonction
     */
    public String getFonction() {
        return fonction;
    }

    /**
     * Set the value of fonction
     *
     * @param fonction new value of fonction
     */
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof Entreprise)) {
            return false;
        }
        Entreprise other = (Entreprise) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Entreprise[ id=" + id + " ]";
    }
    
}
