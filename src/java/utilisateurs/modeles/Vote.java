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
import javax.persistence.OneToOne;

/**
 *
 * @author Aicha
 */
@Entity
public class Vote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     @OneToOne
    private Tshirt tshirt;
      @OneToOne
    private Utilisateur utilisateur;
    

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Vote(){
        
    }
    public Vote(Tshirt t, Utilisateur u){
        this.tshirt=t;
        this.utilisateur=u;
    }
    public Tshirt getThirt(){
        return tshirt;
    }
    public void setTshirt(Tshirt t)
    {
        this.tshirt=t;
    }
    public void setUtilisateur(Utilisateur u){
        this.utilisateur=u;
    }
    public Utilisateur getUtilisateur(){
        return utilisateur;
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
        if (!(object instanceof Vote)) {
            return false;
        }
        Vote other = (Vote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Vote[ id=" + id + " ]";
    }
    
}
