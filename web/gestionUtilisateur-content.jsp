<%-- 
    Author     : Tom
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>   

<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   



    <!-- Message qui s'affiche lorsque la page est appelé avec un paramètre http message -->  
    <c:if test="${!empty requestScope['message']}">  
        <h2>Reçu message : ${param.message}</h2>  
    </c:if> 

    <!-- Zone qui affiche les Etudiants si le paramètre action vaut listerLesEtudiants -->  
    <c:if test="${requestScope['action'] == 'listerLesEtudiants'}" >  
        <h2>Liste des Etudiants</h2>  

        <table border="10" class="table">  
            <!-- La ligne de titre du tableau des adresses -->  
            <thead>
                <tr>  
                    <td><b>Email</b></td>  
                    <td><b>Nom</b></td>  
                    <td><b>Prenom</b></td>
                    <td><b>Miage</b></td>
                    <td><b>Photo</b></td>
                    <td><b>Passeword</b></td>
                    <td><b>Confirm Passeword</b></td>
                    <td></td>
                </tr>  
            </thead>

            <!-- Ici on affiche les lignes, une par adresse -->  
            <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
            <c:set var="total" value="0"/>  
            <tbody>
                <c:forEach var="e" items="${requestScope['listeEtudiants']}">  
                    <c:if test="${e != null}"> 
                        <tr>
                    <form action="GestionUtilisateur" method="post">
                        <td>${e.email}"</td>  
                        <td><input type="text" name="nom" value="${e.nom}"/></td>  
                        <td><input type="text" name="prenom"  value="${e.prenom}"/></td>
                        <td><input type="text" name="vilEtu" value="${e.vilEtu}"/></td>
                        <td><img src="${e.urlphoto}"/></td>
                        <input type="hidden" name="action" value="updateEtudiant"/>
                        <input type="hidden" name="email" value="${e.email}"/>
                        <td><input type="submit" value="Mettre à jour" name="submit"/></td>
                    </form>
                    <td><a href="GestionUtilisateur?action=deleteEtudiant&pagination=${i*10}&idEtudiant=${e.id}">Supprimer</a></td>
                    <td></td>
                    <c:set var="total" value="${total+1}"/>
                    <!-- On compte le nombre d'adresses -->  

                    </tr>  
                </c:if> 
            </c:forEach> 
            <tr><form action="GestionUtilisateur" method="post">
                <td><input type="email" name="email"/></td>  
                <td><input type="text" name="nom" /></td>  
                <td><input type="text" name="prenom"  /></td>
                <td><input type="text" name="vilEtu" /></td>
                <td>
                    <input type="file" onchange="loadProfilePic(this)" id="photo"/>
                    <input type="hidden" required name="photo" id="profilepic"/>
                    <canvas id="preview" width="0" height="0"></canvas>
                    <script>
                        loadProfilePic = function (e) {
                            // on récupère le canvas où on affichera l'image  
                            var canvas = document.getElementById("preview");
                            var ctx = canvas.getContext("2d");
                            // on réinitialise le canvas: on l'efface, et déclare sa largeur et hauteur à 0  
                            ctx.fillStyle = "white";
                            ctx.fillRect(0, 0, canvas.width, canvas.height);
                            canvas.width = 0;
                            canvas.height = 0;
                            // on récupérer le fichier: le premier (et seul dans ce cas là) de la liste  
                            var file = document.getElementById("photo").files[0];
                            // l'élément img va servir à stocker l'image temporairement  
                            var img = document.createElement("img");
                            // l'objet de type FileReader nous permet de lire les données du fichier.  
                            var reader = new FileReader();
                            // on prépare la fonction callback qui sera appelée lorsque l'image sera chargée  
                            reader.onload = function (e) {
                                //on vérifie qu'on a bien téléchargé une image, grâce au mime type  
                                if (!file.type.match(/image.*/)) {
                                    // le fichier choisi n'est pas une image: le champs profilepicfile est invalide, et on supprime sa valeur  
                                    document.getElementById("photo").setCustomValidity("Il faut télécharger une image.");
                                    document.getElementById("photo").value = "";
                                }
                                else {
                                    // le callback sera appelé par la méthode getAsDataURL, donc le paramètre de callback e est une url qui contient   
                                    // les données de l'image. On modifie donc la source de l'image pour qu'elle soit égale à cette url  
                                    // on aurait fait différemment si on appelait une autre méthode que getAsDataURL.  
                                    img.src = e.target.result;
                                    // le champs profilepicfile est valide  
                                    document.getElementById("photo").setCustomValidity("");
                                    var MAX_WIDTH = 96;
                                    var MAX_HEIGHT = 96;
                                    var width = img.width;
                                    var height = img.height;

                                    // A FAIRE: si on garde les deux lignes suivantes, on rétrécit l'image mais elle sera déformée  
                                    // Vous devez supprimer ces lignes, et modifier width et height pour:  
                                    //    - garder les proportions,   
                                    //    - et que le maximum de width et height soit égal à 96  
                                    if (width > height)
                                    {
                                        height = (height * MAX_HEIGHT) / width;
                                        width = MAX_WIDTH;
                                    }
                                    else if (height > width)
                                    {
                                        width = (width * MAX_WIDTH) / height;
                                        height = MAX_HEIGHT;
                                    }
                                    else
                                    {
                                        height = MAX_HEIGHT;
                                        width = MAX_WIDTH;
                                    }
                                    canvas.width = width;
                                    canvas.height = height;
                                    // on dessine l'image dans le canvas à la position 0,0 (en haut à gauche)  
                                    // et avec une largeur de width et une hauteur de height  
                                    ctx.drawImage(img, 0, 0, width, height);
                                    // on exporte le contenu du canvas (l'image redimensionnée) sous la forme d'une data url  
                                    var dataurl = canvas.toDataURL("image/png");
                                    // on donne finalement cette dataurl comme valeur au champs profilepic  
                                    document.getElementById("profilepic").value = dataurl;
                                }
                            };
                            // on charge l'image pour de vrai, lorsque ce sera terminé le callback loadProfilePic sera appelé.  
                            reader.readAsDataURL(file);
                        };
                    </script>
                </td>
                <td><input type="password" name="mdp" /></td>
                <td><input type="password" /></td>
                <input type="hidden" name="action" value="ajouterEtudiant"/>
                <td><input type="submit" value="ajouter" name="submit"/></td></form></tr>


            <!-- Affichage du solde total dans la dernière ligne du tableau -->  
            <tr><td><b>TOTAL</b></td><td></td><td></td><td></td><td></td><td></td><td></td><td><b>${total}/${requestScope['nombreEtudiants']}</b></td></tr> 
            </tbody>
        </table>
        <ul class="pagination">
            <c:forEach var="i" begin="0" end="${requestScope['nombreEtudiants']/10}">
                <c:if test="${requestScope['pagination'] == i}">
                    <li class="active"><a  href="GestionUtilisateur?action=listerLesEtudiants&pagination=${i*10}">${i}</a></li>
                    </c:if>
                    <c:if test="${requestScope['pagination'] != i}">
                    <li><a  href="GestionUtilisateur?action=listerLesEtudiants&pagination=${i*10}">${i}</a></li>
                    </c:if>
                </c:forEach>
        </ul>

    </c:if> 