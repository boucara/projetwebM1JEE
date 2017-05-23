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

   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css" />

         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>  
    <body>  
        <jsp:include page="header.jsp"/> 

        <div class="main">
            <!-- Contact Container -->
            <div class="w3-container w3-padding-64 w3-theme-l5" id="contact">
                <h1>${param.title}</h1>

                <jsp:include page="${param.content}.jsp"/>
            </div>
            
           



        </div>

        <jsp:include page="footer.jsp"/>  


    </body>  
</html>
