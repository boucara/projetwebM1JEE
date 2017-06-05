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
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/outils.js"></script>
        <script>
            var map;
            function initMap() {
                map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: 47.74779817, lng: 7.341755199999966},
                    zoom: 8
                });
            }
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDcVwYXpSfbjWnaRAUvYPjgRY9MulFoaRk&callback=initMap"
        async defer></script>

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
