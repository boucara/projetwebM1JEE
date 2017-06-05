<%-- 
    Document   : PageContent
    Created on : 22 mai 2017, 14:16:11
    Author     : Aicha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<div class="container">
    <div class="row">


        <c:forEach  var="e" items="${requestScope['events']}">
            <div class="col-sm-4">
                <h2>${e.nom}</h2>
                <p><img src="${e.urlphoto}" alt="${e.nom}" style="width:100%;"/></p>

                <p><div>${e.description}</div></p>
                <p><div>${e.datePublication}</div></p>
            </div>
        </c:forEach>


    </div>
    <div class="row">
        <!-- Left and right controls -->
        <a class="col-sm-4" href="#myCarousel">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="col-offset-8" href="#myCarousel" >
            <span class="glyphicon glyphicon-chevron-right"></span>

        </a>
    </div>

</div>


