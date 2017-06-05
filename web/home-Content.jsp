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
        <c:if test="${requestScope['pagination'] != 0}">
            <a class="col-sm-4" href="Accueil?pagination=${requestScope['pagination']-1}">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
        </c:if>
        <c:if test="${requestScope['pagination'] == 0}">
            <a class="col-sm-4" href="#"/>
        </c:if>
        <c:if test="${requestScope['pagination'] < requestScope['nombreEvents']-3}">
            <a class="col-offset-8" href="Accueil?pagination=${requestScope['pagination']+1}" >
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </c:if>
    </div>

</div>


