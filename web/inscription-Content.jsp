<%-- 
    Document   : PageContent
    Created on : 22 mai 2017, 14:16:11
    Author     : Aicha
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<br/>
<br/>
<c:if test="${requestScope['etape'] == 'etape1'}">
    <form class="form-horizontal" action="Inscription" method="post">
        <div class="form-group">
            <label class="control-label col-sm-5" for="email">Email :</label>
            <div class="col-sm-2"> 
                <input class="form-control" title="exemple@exemple.com" placeholder="Entrer votre adresse mail" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}" required type="mail" id="email" name="email"/>
            </div>
        </div> 
        <div class="form-group">
            <label class="control-label col-sm-5" for="nom">Nom : </label>
            <div class="col-sm-2"><input class="form-control" placeholder="Entrez votre nom" required type="text" id="nom" name="nom"/></div>
        </div>  
        <div class="form-group">
            <label class="control-label col-sm-5" for="prenom">Prénom :</label>
            <div class="col-sm-2"> <input class="form-control" placeholder="Entrez votre prénom" required type="text" id="prenom" name="prenom"/></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-5" for="mdp">MDP :</label>
            <div class="col-sm-2"> 
                <input class="form-control" required onkeyup="validateMdp2('mdp', 'mdpconfirm')" type="password" id="mdp" name="mdp" pattern="^[a-z0-9A-Z]{6,20}" placeholder="Entrer votre mot de passe (6 à 20 caractères alphanumériques)" title="6 à 20 caractères alphanumériques"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-5" for="mdpconfirm">Confirmer MDP :</label>
            <div class="col-sm-2"> 
                <input class="form-control" required onkeyup="validateMdp2('mdp', 'mdpconfirm')" type="password" id="mdpconfirm" pattern="^[a-z0-9A-Z]{6,20}" placeholder="Confirmez votre mot de passe (6 à 20 caractères alphanumériques)" title="6 à 20 caractères alphanumériques"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-8">
                <label><input type="radio" name="categorie" value="entreprise" required> Entreprise&nbsp;&nbsp;&nbsp;</label>
                <label><input type="radio" name="categorie" value="etudiant"> Etudiant&nbsp;&nbsp;&nbsp;</label>
                <label><input type="radio" name="categorie" value="enseignant"> Enseignant</label>
            </div>
        </div>
        <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->  
        <input type="hidden" name="etape" value="etape1"/>  
        <input type="submit" value="Valider" name="submit" class="btn btn-default"/>  
    </form> 
</c:if>
<c:if test="${requestScope['etape'] == 'etape2'}">  
    <c:if test="${requestScope['categorie'] == 'entreprise'}">
        <form action="Inscription" method="post">  
            <div class="form-group">
                <label class="control-label col-sm-2" for="function">Function : </label>
                <div class="col-sm-10"><input type="text" name="function"/></div>
            </div><br>  
            <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->  
            <input type="hidden" name="etape" value="etape2"/>  
            <input type="submit" value="Valider" name="submit" class="btn btn-default"/>  
        </form>
    </c:if>
    <c:if test="${requestScope['categorie'] == 'entreprise'}">

    </c:if>
</c:if>