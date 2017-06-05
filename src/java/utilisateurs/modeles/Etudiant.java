/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.modeles;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Tom
 */
@Entity
public class Etudiant extends Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    private String vilEtu;
    private boolean ancien;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private byte[] image;
    @Transient
    private String urlphoto;

    public String getUrlphoto() {
        return urlphoto;
    }

    public void setUrlphoto(String urlphoto) {
        this.urlphoto = urlphoto;
    }

    public Etudiant() {

    }

    public Etudiant(String email, String nom, String prenom, String mdp) {
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
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if (getId() != other.getId()) {
            return false;
        }
        return true;
    }

    public String getVilleEtu() {
        return vilEtu;

    }

    public void setVilleEtu(String vilEtu) {
        this.vilEtu = vilEtu;
    }

    public boolean getAcien() {
        return ancien;

    }

    public void setAncien(boolean ancien) {
        this.ancien = ancien;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;

    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Etudiants[ id=" + getId() + " ]";
    }

}
