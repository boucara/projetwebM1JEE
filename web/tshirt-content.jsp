<%-- 
    Document   : Tshirt-content
    Created on : 29 mai 2017, 23:35:13
    Author     : Aicha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${param['action'] == 'creerTshirtconcour'}">
    <form action="ServletTshirt" method="get">  
        <input type="button" value="partiConcour" name="button" class="btn btn-default" />  
    </form>
    </c:if> 

