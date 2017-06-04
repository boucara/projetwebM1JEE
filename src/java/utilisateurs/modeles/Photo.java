/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.modeles;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aicha
 */
@Entity
@NamedQuery(name="toutes", query="SELECT photo FROM Photo AS photo")
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date instant;
    @Column(nullable = false)
    private int largeur;
    @Column(nullable = false)
    private int hauteur;
    private long poids;
    private String nom;

    public Photo() {
    }

    public Photo(String nom, long poids) {
        this.nom = nom;
        instant = new Date();
        this.poids = poids;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photo)) {
            return false;
        }
        Photo other = (Photo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Date getInstant() {
        return instant;
    }

    public int getLargeur() {
        return largeur;
    }

    public long getPoids() {
        return poids;
    }

    public void setDimensions(BufferedImage image) {
        largeur = image.getWidth();
        hauteur = image.getHeight();
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Photo[ id=" + id + " ]";
    }

}
