<%-- 
    Document   : template
    Created on : 22 mai 2017, 14:18:42
    Author     : Aicha
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML>  
<html>  
    <head>  
        <title>${param.title}</title>  
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css" /> 
    </head>  
    <body>  
        <jsp:include page="header.jsp"/> 
        
        <div class="main">
            <h1>${param.title}</h1>
            <jsp:include page="${param.content}.jsp"/>
        </div>
          
        <jsp:include page="footer.jsp"/>  
          
          
    </body>  
</html>
