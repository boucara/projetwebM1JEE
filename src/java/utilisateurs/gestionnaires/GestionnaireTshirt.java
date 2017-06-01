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
import utilisateurs.modeles.Tshirt;

/**
 *
 * @author Aicha
 */
@Entity
public class GestionnaireTshirt implements Serializable {

    
    @PersistenceContext
    private EntityManager em;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
        if (!(object instanceof GestionnaireTshirt)) {
            return false;
        }
        GestionnaireTshirt other = (GestionnaireTshirt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Tshirt creerTshirt(String miage, String pays, byte[] image) {
        Tshirt t = new Tshirt(miage, pays, image);
        em.persist(t);
        return t;

    }
    public void creerTshirtconcour(){
         byte[] imageBytes = {0x32, 0x32,0x32, 0x32,0x32,
               0x32,0x32, 0x32,
               0x32, 0x32,0x32, 0x32,0x32, 0x32,0x32, 0x32,
               0x32, 0x32,0x32, 0x32,0x32, 0x32,0x32, 0x32
               };
        creerTshirt("Nice","Chine",imageBytes);
    }
    public Collection<Tshirt> getTshirtConcour() {  
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select t from Tshirt t");  
        return q.getResultList();  
    }  
    @Override
    public String toString() {
        return "utilisateurs.gestionnaires.GestionnaireTshirt[ id=" + id + " ]";
    }

}
