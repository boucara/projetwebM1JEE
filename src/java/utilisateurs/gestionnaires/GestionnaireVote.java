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
import utilisateurs.modeles.Utilisateur;
import utilisateurs.modeles.Vote;

/**
 *
 * @author Aicha
 */
@Stateless
public class GestionnaireVote {

    @PersistenceContext
    private EntityManager em;
   
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Vote creeVote( Tshirt t, Utilisateur u) {  
        
        Vote v = new Vote( t, u);  
        em.persist(v);  
        return v;  
    } 

    public int compterVote(int id) {
        int result = 0;
        Collection<Vote> votes = getVotesList();
        if (votes != null) {
            for (Vote vote :votes) {
                if(id==vote.getThirt().getId()){
                    result++;
                }

            }
        }

        return result;

    }
    public Tshirt getTshirt(int id){
        Query q = em.createQuery("select t from Tshirt t where t.id='"+id+"'");
        if(q.getSingleResult()!=null) {
            return (Tshirt) q.getSingleResult();
        }
        else {
            return null;
        }
        
        
    }

    public Collection<Vote> getVotesList() {
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select v from Vote v");
        return q.getResultList();
    }
}
