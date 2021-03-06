<%-- 
    Document   : concourVideo-content
    Created on : 4 juin 2017, 18:26:34
    Author     : Aicha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:if test="${param['action'] == 'concourVideo'}">
    <h3> Bienvenue! sur la page du concour vidéo </h3>
    <div class="container-fluid" id ="content" >
        <div class="row content">
            <div class="col-sm-3 sidenav" id ="sidbar">
                <p id="para"> Thème : Etudiants à l'étranger dans le cadre d'un échange Erasmus.C'est le moment de parler du concours vidéo. 
                    Il est grand temps pour vous de nous réaliser des vidéos dignes de ce nom.
                    Pour avoir la chance de remporter cette édition, vous devez respecter les contraintes suivantes :
                </p>
                <table class="table">
                    <tbody>
                        <tr class="active"> 
                            <td>#</td>
                            <td>intitulé</td>
                        </tr>

                        <tr class="warning"> 
                            <td>1</td>
                            <td>Placer une scéne de film culte</td>
                        </tr>
                        <tr class="danger">
                            <td>2</td>
                            <td>Faire apparaitre un évenement étrange en arriére-plan</td>
                        </tr>
                        <tr class="success"> 
                            <td>3</td>
                            <td> Parler une langue étrangére</td>
                        </tr>
                        <tr> 
                            <td>4</td>
                            <td> Parler en alexandrins pendant 30 secondes</td>
                        </tr>
                        <tr class="warning"> 
                            <td>5</td>
                            <td> 	Placer une licorne</td>
                        </tr>
                        <tr class="info">
                            <td>6</td>
                            <td>Dévoiler un talent caché</td>
                        </tr>
                        <tr class="success"> 
                            <td>7</td>
                            <td>Placer du schnaps</td>
                        </tr>
                        <tr class="danger"> 
                            <td>8</td>
                            <td>Le tout pour une durée maximale de 12 min.</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-9" id ="contenuVideo">
                
                <object type="application/x-shockwave-flash" width="425" height="355" data="http://www.youtube.com/v/EuFUPUHQnLY&feature;h1=fr">

                    <param name="movie" value="http://www.youtube.com/v/EuFUPUHQnLY&feature;h1=fr" />


                    <param name="wmode" value="transparent" />

                </object>
            </div>
        </div>
    </div>


</c:if> 