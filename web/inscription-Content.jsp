<%-- 
    Document   : PageContent
    Created on : 22 mai 2017, 14:16:11
    Author     : Aicha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<br/>
<br/>
<c:if test="${requestScope['etape'] == 'etape1'}">
    <form class="form-horizontal" action="Inscription" method="post">
        <div class="form-group">
            <label class="control-label col-sm-5" for="email">Email :</label>
            <div class="col-sm-2"> <input class="form-control" type="text" id="email" name="email"/></div>
        </div> 
        <div class="form-group">
            <label class="control-label col-sm-5" for="nom">Nom : </label>
            <div class="col-sm-2"><input class="form-control" type="text" id="nom" name="nom"/></div>
        </div>  
        <div class="form-group">
            <label class="control-label col-sm-5" for="prenom">Prénom :</label>
            <div class="col-sm-2"> <input class="form-control" type="text" id="prenom" name="prenom"/></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-5" for="mdp">MDP :</label>
            <div class="col-sm-2"> <input class="form-control" type="password" id="mdp" name="mdp"/></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-5" for="mdp">Confirmer MDP :</label>
            <div class="col-sm-2"> <input class="form-control" type="password" id="mdpconfirm"/></div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-8">
                <label><input type="radio" name="categorie" value="entreprise"> Entreprise&nbsp;&nbsp;&nbsp;</label>
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