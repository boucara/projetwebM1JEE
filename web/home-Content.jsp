<%-- 
    Document   : PageContent
    Created on : 22 mai 2017, 14:16:11
    Author     : Aicha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<div>
    <c:forEach  var="e" items="${requestScope['events']}">
        <div>
            <div>${e.nom}</div> 
            <div><img src="${e.photo}"/></div> 
            <div>${e.description}</div> 
            <div>${e.datePublication}</div>
        </div>
    </c:forEach>
</div>










