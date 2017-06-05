<%-- 
    Document   : PageContent
    Created on : 22 mai 2017, 14:16:11
    Author     : Aicha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<div>
    <c:if test="${param['action'] == 'seConnecter'}">
        <h1>hello connexion reussi </h1>

    </c:if>
    <c:if test="${param['action'] != 'seConnecter'}">
        <c:forEach  var="e" items="${requestScope['events']}">
            <div>
                <div>${e.nom}</div> 
                <div><img src="${e.urlphoto}"/></div> 
                <div>${e.description}</div> 
                <div>${e.datePublication}</div>
            </div>
        </c:forEach>
    </c:if>
</div>










