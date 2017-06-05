<%-- 
    Document   : header
    Created on : 22 mai 2017, 14:18:18
    Author     : Aicha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!-- Navbar -->
<nav class="navbar navbar-fixed-top">
    <a href="http://miageprojet2.unice.fr/">  
        <img src="${pageContext.request.contextPath}/resources/images/logo_miage.png"/>  
    </a>  
    <a href="http://unice.fr/">  
        <img src="${pageContext.request.contextPath}/resources/images/logo_uns.png"/>  
    </a>  
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
            </button>
            <a class="navbar-brand" href="Accueil">JNM 2018</a>
        </div>
        <div class="collapse navbar-collapse" id="menu">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Accueil">HOME</a></li>
                <li><a href="DesInformation?action=info">Informations pratiques</a></li>

                <c:choose>
                    <c:when test="${requestScope['connexion'] != null && requestScope['connexion'] == 'true'}">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" >Activités
                                <span class="caret"></span></a>

                            <ul class="dropdown-menu">
                                <li><a href="Video?action=concourVideo">Concours Vidéos</a></li>
                                <li><a href="Tshirt?action=creerTshirtconcour">Concours T-Shirt</a></li>
                                <li><a href="#">Trombinoscope</a></li> 
                                <li><a href="#">Resultats Votes</a></li> 
                                <li><a href="#">Packs</a></li>  
                            </ul>

                        </li>

                        <li><a href="#">Bonjour ${requestScope['utilisateur'].prenom}</a></li> 
                        <li><a href="Deconnexion">Deconnexion</a></li>
                        </c:when>    
                        <c:otherwise>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" >
                                Se connecter
                                <span class="caret"></span>
                            </a>

                            <form class="dropdown-menu" aria-labelledby="dropdownMenu1" action="Connexion" method="post">
                                <div class="form-group"> <label for="mail">Mail :</label> <input type="text" id="mail" required name="mail" class="form-control"/></div>
                                <div class="form-group"> <label for="mdpco">MDP :</label> <input type="password" pattern="^[a-z0-9A-Z]{6,20}" id="mdpco" required name="mdpco" class="form-control"/></div>
                                <input type="submit" value="Valider" name="submit" class="btn btn-default"/>
                            </form>

                        </li>


                        <li><a href="Inscription">Participer</a></li>
                        </c:otherwise>
                    </c:choose>
            </ul>
        </div>
    </div>
</nav>

