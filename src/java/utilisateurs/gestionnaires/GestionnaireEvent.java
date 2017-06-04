/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaires;

import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Event;

/**
 *
 * @author user
 */
@Startup
@Singleton
public class GestionnaireEvent {
    @PersistenceContext  
    private EntityManager em;
    
    @PostConstruct
    public void init() {
        String img = "data:image/gif;base64,R0lGOD lhCwAOAMQfAP////7+/vj4+Hh4eHd3d/v7+/Dw8HV1dfLy8ubm5vX19e3t7fr 6+nl5edra2nZ2dnx8fMHBwYODg/b29np6eujo6JGRkeHh4eTk5LCwsN3d3dfX 13Jycp2dnevr6////yH5BAEAAB8ALAAAAAALAA4AAAVq4NFw1DNAX/o9imAsB tKpxKRd1+YEWUoIiUoiEWEAApIDMLGoRCyWiKThenkwDgeGMiggDLEXQkDoTh CKNLpQDgjeAsY7MHgECgx8YR8oHwNHfwADBACGh4EDA4iGAYAEBAcQIg0Dk gcEIQA7";
        insertEvent("ultricies adipiscing, enim mi tempor", "eu nulla at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a, aliquet vel, vulputate eu, odio. Phasellus at augue id ante dictum cursus. Nunc mauris", img.getBytes());
        insertEvent("elit. Curabitur sed tortor. Integer", "et malesuada fames ac turpis egestas. Fusce aliquet magna a neque. Nullam ut nisi a odio semper cursus. Integer mollis. Integer tincidunt aliquam arcu. Aliquam ultrices iaculis odio. Nam interdum", img.getBytes());
        insertEvent("ultricies adipiscing, enim mi tempor", "lobortis quam a felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed diam lorem, auctor quis, tristique ac, eleifend vitae, erat. Vivamus nisi. Mauris nulla. Integer urna. Vivamus molestie dapibus ligula.", img.getBytes());
        insertEvent("elit. Curabitur sed tortor. Integer", "eu nulla at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a, aliquet vel, vulputate eu, odio. Phasellus at augue id ante dictum cursus. Nunc mauris", img.getBytes());
        insertEvent("ultricies adipiscing, enim mi tempor", "lobortis quam a felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed diam lorem, auctor quis, tristique ac, eleifend vitae, erat. Vivamus nisi. Mauris nulla. Integer urna. Vivamus molestie dapibus ligula.", img.getBytes());
    }

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
        return q.getResultList();
    }
}
