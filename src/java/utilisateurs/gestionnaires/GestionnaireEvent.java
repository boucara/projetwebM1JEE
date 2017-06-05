/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaires;

import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Event;

/**
 *
 * @author user
 */
@Stateless
public class GestionnaireEvent {
    @PersistenceContext  
    private EntityManager em;

    private Event creerEvent(String nom, String description, byte[] photo) {
        Date datePublication = new Date();
        Event e = new Event(nom, description, datePublication, photo);
        return e;
    }
    
    public void insertEvent(String nom, String description, byte[] photo){
        Event e = creerEvent(nom, description, photo);
        em.persist(e);
    }
    
    public Collection<Event> selectEvents(int pagination){
        Query q = em.createQuery("select e from Event e ");
        q.setFirstResult(pagination);
        q.setMaxResults(3);
        Collection<Event> collection = q.getResultList();
        for(Event e : collection){
            e.setUrlphoto(new String(e.getPhoto()));
        }
        return collection;
    }
    
    public int getNumberEvents() {
        Query q = em.createQuery("select e from Event e ");
        return q.getResultList().size();
    }
}
