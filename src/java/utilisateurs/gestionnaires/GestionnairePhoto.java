/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.gestionnaires;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utilisateurs.modeles.Photo;

/**
 *
 * @author Aicha
 */
@Stateless
public class GestionnairePhoto {

    private final String répertoire = "../../../../web/resources/images";
    @PersistenceContext
    EntityManager persistance;

    public void stocker(String nom, byte[] octets) throws IOException {
        File fichier = new File(répertoire + nom);
        if (fichier.exists()) {
            return;
        }
        FileOutputStream fluxphoto = new FileOutputStream(fichier);
        fluxphoto.write(octets);
        fluxphoto.close();
        enregistrer(nom);
    }

    @Asynchronous
    private void enregistrer(String nom) throws IOException {
        File fichier = new File(répertoire + nom);
        BufferedImage image = ImageIO.read(fichier);
        Photo photo = new Photo(nom, fichier.length());
        photo.setDimensions(image);
        persistance.persist(photo);
    }

    public byte[] restituer(String nom) throws IOException {
        File fichier = new File(répertoire + nom);
        if (!fichier.exists()) {
            return null;
        }
        FileInputStream fluxphoto = new FileInputStream(fichier);
        byte[] octets = new byte[(int) fichier.length()];
        fluxphoto.read(octets);
        fluxphoto.close();
        return octets;
    }

    public List<Photo> getListe() {
        return persistance.createNamedQuery("toutes").getResultList();
    }

    public Photo getPhoto(String nom) {
        return persistance.find(Photo.class, nom);
    }

    public void supprimer(String nom) {
        new File(répertoire + nom).delete();
        Photo photo = getPhoto(nom);
        persistance.remove(photo);
    }

}
