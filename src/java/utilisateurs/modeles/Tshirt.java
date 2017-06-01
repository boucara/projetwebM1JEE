/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.modeles;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author Aicha
 */
@Entity
public class Tshirt implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String miage;
    private String pays;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private byte[] image;
    public Tshirt(){
        
    }
    public Tshirt(String miage , String pays, byte[] image){
        this.miage=miage;
        this.pays=pays;
        this.image=image;
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
        if (!(object instanceof Tshirt)) {
            return false;
        }
        Tshirt other = (Tshirt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Tshirt[ id=" + id + " ]";
    }
    public String getMiage(){
        return miage;
    }
    public void setMiage(String miage){
        this.miage=miage;
    }
    public String getPays(){
        return pays;
        
    }
    public void setPays(String pays){
        this.pays=pays;
    }
     public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
}
