<%-- 
    Document   : classementVote-content
    Created on : 6 juin 2017, 01:15:15
    Author     : Aicha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${param['action'] == 'voteTshirt'}">
    <h1> Classement des Tshirts</h1>
</c:if>