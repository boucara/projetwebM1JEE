/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaires;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Tshirt;

/**
 *
 * @author Aicha
 */
@Stateless
public class GestionnaireTshirt {

    @PersistenceContext
    private EntityManager em;

    public Tshirt creerTshirt(String miage, String pays, byte[] image) {
        Tshirt t = new Tshirt(miage, pays, image);
        em.persist(t);
        return t;

    }

    public void creerTshirtconcour() {
        byte[] imageBytes = {0x32, 0x32, 0x32, 0x32, 0x32,
            0x32, 0x32, 0x32,
            0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32,
            0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32
        };
        creerTshirt("Nice", "Chine", imageBytes);
    }

    public Collection<Tshirt> getTshirtConcour() {
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select t from Tshirt t");
        return q.getResultList();
    }
}
