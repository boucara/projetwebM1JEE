<%-- 
    Document   : PageContent
    Created on : 22 mai 2017, 14:16:11
    Author     : Aicha
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<br/>
<br/>

<!--Première étape de l'inscription-->

<c:if test="${requestScope['etape'] == 'etape1'}">
    <form class="form-horizontal" action="Inscription" method="post">

        <!--Gestion de l'adresse email-->
        <div class="form-group">
            <label class="control-label col-sm-4" for="email">Email :</label>
            <div class="col-sm-4"> 
                <input class="form-control" onchange="validateEmail('email', 'Inscription')" title="exemple@exemple.com" placeholder="Entrer votre adresse mail" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}" required type="mail" id="email" name="email" 
                       <c:if test="${requestScope['utilisateur'] != null}">
                           value="${requestScope['utilisateur'].email}"
                       </c:if>/>
            </div>
        </div> <br/>

        <!--Gestion du nom de l'utilisateur-->
        <div class="form-group">
            <label class="control-label col-sm-4" for="nom">Nom : </label>
            <div class="col-sm-4">
                <input class="form-control" placeholder="Entrez votre nom" required type="text" id="nom" name="nom"
                       <c:if test="${requestScope['utilisateur'] != null}">
                           value="${requestScope['utilisateur'].nom}"
                       </c:if>/>
            </div>
        </div> <br/>

        <!--Gestion du prenom de l'utilisateur-->
        <div class="form-group">
            <label class="control-label col-sm-4" for="prenom">Prénom :</label>
            <div class="col-sm-4">
                <input class="form-control" placeholder="Entrez votre prénom" required type="text" id="prenom" name="prenom"
                       <c:if test="${requestScope['utilisateur'] != null}">
                           value="${requestScope['utilisateur'].prenom}"
                       </c:if>/>
            </div>
        </div><br/>

        <!--Gestion du mdp passe de l'utilisateur-->
        <div class="form-group">
            <label class="control-label col-sm-4" for="mdp">MDP :</label>
            <div class="col-sm-4"> 
                <input class="form-control" required onkeyup="validateMdp2('mdp', 'mdpconfirm')" type="password" id="mdp" name="mdp" pattern="^[a-z0-9A-Z]{6,20}" placeholder="Entrer votre mot de passe (6 à 20 caractères alphanumériques)" title="6 à 20 caractères alphanumériques"/>
            </div>
        </div><br/>

        <!--Confirmation du mot de passe de l'utilisateur-->
        <div class="form-group">
            <label class="control-label col-sm-4" for="mdpconfirm">Confirmer MDP :</label>
            <div class="col-sm-4"> 
                <input class="form-control" required onkeyup="validateMdp2('mdp', 'mdpconfirm')" type="password" id="mdpconfirm" pattern="^[a-z0-9A-Z]{6,20}" placeholder="Confirmez votre mot de passe (6 à 20 caractères alphanumériques)" title="6 à 20 caractères alphanumériques"/>
            </div>
        </div><br/>

        <!--Gestion de la catégorie de l'utilisateur-->
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-8">
                <label><input type="radio" name="categorie" value="entreprise" required> Entreprise&nbsp;&nbsp;&nbsp;</label>
                <label><input type="radio" name="categorie" value="etudiant"> Etudiant&nbsp;&nbsp;&nbsp;</label>
                <label><input type="radio" name="categorie" value="enseignant"> Enseignant</label>
            </div>
        </div><br/>
        <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->  
        <input type="hidden" name="etape" value="etape1"/>  
        <input type="submit" value="Valider" name="submit" class="btn btn-default"/>  
    </form> 
</c:if>

<!--Cas de la deuxième étape-->
<c:if test="${requestScope['etape'] == 'etape2'}"> 
    <a id="retouretape" href="Inscription">Retour à l'étape 1</a> <br/>
    <br/>
    <br/>
    <!--Cas de l'inscription d'une entreprise-->
    <c:if test="${requestScope['categorie'] == 'entreprise'}">
        <form class="form-horizontal" action="Inscription" method="post">  

            <!--Gestion de la fonction de l'utilisateur au sein de l'entreprise-->
            <div class="form-group">
                <label class="control-label col-sm-4" for="function">Function : </label>
                <div class="col-sm-4">
                    <input class="form-control" placeholder="Entrez votre function au sein de l'entreprise" id="function" required type="text" name="function"/>
                </div>
            </div><br/>

            <!--Gestion du teléphone de m'utilisateur-->
            <div class="form-group">
                <label class="control-label col-sm-4" for="tel">Tel : </label>
                <div class="col-sm-4">
                    <input class="form-control" type="tel" placeholder="Entrez un numéro de téléphone joignable" id="tel" required name="tel" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$"/>
                </div>
            </div><br/>

            <!--Gestion du nom de l'entreprise-->
            <div class="form-group">
                <label class="control-label col-sm-4" for="nomEntreprise">Nom Entreprise : </label>
                <div class="col-sm-4">
                    <input class="form-control" type="text" placeholder="Entrez le nom de votre etreprise" id="nomEntreprise" required name="nomEntreprise"/>
                </div>
            </div><br/>

            <!--Gestion de la fonction de l'utilisateur au sein de l'entreprise-->
            <div class="form-group">
                <label class="control-label col-sm-4" for="secteurActivite">Secteur d'activité : </label>
                <div class="col-sm-4">
                    <input class="form-control" type="text" placeholder="Entrez le secteur d'activité de votre entreprise" id="secteurActivite" required name="secteurActivite"/>
                </div>
            </div><br/>
            <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->  
            <input type="hidden" name="etape" value="etape2"/>  
            <input type="submit" value="Valider" name="submit" class="btn btn-default"/>  
        </form>
    </c:if>

    <!--Cas de l'inscription d'un étudiant-->
    <c:if test="${requestScope['categorie'] == 'etudiant'}">
        <script>
            var datefield = document.createElement("input");
            datefield.setAttribute("type", "date");
            if (datefield.type != "date") { //if browser doesn't support input type="date", initialize date picker widget:
                jQuery(function ($) { //on document.ready

                    $('#date').datepicker({
                        changeMonth: true,
                        changeYear: true,
                        dateFormat: 'yy-mm-dd',
                        yearRange: "c-100:c"
                    });
                });
            }
        </script>
        <form class="form-horizontal" action="Inscription" method="post">  

            <!--Gestion de la date de naissance de l'étudiant-->
            <div class="form-group">
                <label class="control-label col-sm-4" for="date">Date de naissance : </label>
                <div class="col-sm-4">
                    <input class="form-control" placeholder="Entrez votre date de naissance (AAAA-MM-JJ)" pattern="\d{4}-\d{2}-\d{2}" id="date" required type="date" name="date"/>
                </div>
            </div><br/>

            <!--Gestion du centre de formation de l'étudiant-->
            <div class="form-group">
                <label class="control-label col-sm-4" for="miage">Miage : </label>
                <div class="col-sm-2">
                    <select id="miage" required name="miage">
                        <option>Aix en Provence
                        <option>Bordeau
                        <option>Créteil
                        <option>Evry
                        <option>Grenoble
                        <option>Lille
                        <option>Lyon
                        <option>Marseille
                        <option>Mulhouse
                        <option>Nancy
                        <option>Nanterre
                        <option>Nantes
                        <option>Nice
                        <option>Orléans
                        <option>Orsay
                        <option>Paris
                        <option>Rennes
                        <option>Toulouse
                        <option>Valence
                    </select>
                </div>
            </div><br/>

            <!--Gestion de la photo de l'étudiant-->
            <div class="form-group">
                <label class="control-label col-sm-4" for="photo">Photo de profil : </label>
                <div class="col-sm-2">
                    <input class="form-control" type="file" onchange="loadProfilePic(this)" id="photo" required/>
                </div>
            </div>
            <div class="form-group">
                <input type="hidden" required name="photo" id="profilepic"/>
                <div class="col-sm-4">
                    <canvas id="preview" width="0" height="0"></canvas>
                </div>
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
            </div>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-4">
                    <div class="checkbox">
                        <label><input type="checkbox" id="ancien" name="ancien"/>Ancien miagiste</label>
                    </div>
                </div>
            </div><br/>
            <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->  
            <input type="hidden" name="etape" value="etape2"/>  
            <input type="submit" value="Valider" name="submit" class="btn btn-default"/>  
        </form>
    </c:if>
</c:if>