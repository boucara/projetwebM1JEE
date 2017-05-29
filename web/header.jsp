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
            <c:if test="${requestScope['user'] == null}">
                <li class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" >
                        Se connecter
                        <span class="caret"></span>
                    </button>

                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <li> <label>mail :</label> <input type="text" name="mail" class="form-control"/></li>
                        <li> <label>MDP :</label> <input type="password" name="mdp" class="form-control"/></li>
                        <input type="hidden" name="action" value="seConnecter"/> 
                        <li><input type="submit" value="Se Connecter" name="submit" class="btn btn-default"/> </li>
                    </ul>

                </li>
            </c:if>
        </div>
        <div class="collapse navbar-collapse" id="menu">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Accueil">HOME</a></li>
                <li><a href="#">Informations pratiques</a></li>

                <c:choose>
                   <c:when test="${requestScope['connexion'] != null && requestScope['connexion'] == 'true'}">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" >Activités
                                <span class="caret"></span></a>
                               
                                <ul class="dropdown-menu">
                                    <li><a href="#">Concours Vidéos</a></li>
                                    <li><a href="Tshirt">Concours T-Shirt</a></li>
                                    <li><a href="#">Trombinoscope</a></li> 
                                    <li><a href="#">Resultats Votes</a></li> 
                                    <li><a href="#">Packs</a></li>  
                                </ul>
                           
                        </li>
                        
                        <li><a href="#">Bonjour ${requestScope['utilisateur'].prenom}</a></li>
                        <li><a href="Deconnexion">Deconnexion</a></li>
                        </c:when>    
                        <c:otherwise>




                        <li><a href="Inscription">Participer</a></li>
                        </c:otherwise>
                    </c:choose>
            </ul>
        </div>
    </div>
</nav>

