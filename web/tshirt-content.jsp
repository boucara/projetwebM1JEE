<%-- 
    Document   : Tshirt-content
    Created on : 29 mai 2017, 23:35:13
    Author     : Aicha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${param['action'] == 'creerTshirtconcour'}">
    <c:forEach  var="t" items="${requestScope['concour']}">
        <div>${t.miage}</div> 
        <div>${t.pays}</div> 
        <div><img src="${t.urlphoto}"/></div>

    </c:forEach>
    <form action="ServeletTshirt" method="get">  
        <input type="button" value="partiConcour" name="button" class="btn btn-default" />  
    </form>
</c:if> 

