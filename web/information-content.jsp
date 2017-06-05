<%-- 
    Document   : information-content
    Created on : 5 juin 2017, 14:11:21
    Author     : Aicha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:if test="${param['action'] == 'info'}">
    <html>
        <div class="container-fluid" id ="info" >
            <div class="row content">
                <div class="col-sm-6" >

                    <ul class="list-group">
                        <li class="list-group-item active"> <h3>Accessibilité :</h3></li>



                        <li class="list-group-item "> En train : Gare Centrale de Mulhouse.</li>
                        <li class="list-group-item ">En voiture : Le parking de la fac, situé au 18 rue des frères Lumière est gratuit.</li>
                        <li  class="list-group-item ">En avion : Aéroport EuroAirport Bâle-Freiburg-Mulhouse</li>


                    </ul>


                    <ul class="list-group">
                        <li class="list-group-item active"> <h3> Lieux : </h3></li>
                        <li class="list-group-item "><h3>Pour les hébergements :</h3></li>
                        <li class="list-group-item ">Hôtel Salvator : 29 passage central, 68100 MULHOUSE</li>
                        <li class="list-group-item ">Hôtel B&B Mulhouse Centre : 38 avenue de Colmar, 68100 MULHOUSE</li>
                        <li class="list-group-item ">Auberge de Jeunesse : 37 rue de l’Illberg, 68200 MULHOUSE</li>

                        <li  class="list-group-item ">(les petits déjeuners sont compris)</li>
                    </ul>

                </div>
                <div class="col-sm-6">
                    <p>29 passage central, 68100 MULHOUSE</p>

                    <div id="map" style="height:300px; width:500px"></div>

                </div>
            </div>
        </div>
    </html>

</c:if>
