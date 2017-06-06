<%-- 
    Document   : Tshirt-content
    Created on : 29 mai 2017, 23:35:13
    Author     : Aicha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${param['action'] == 'creerTshirtconcour'}">
    <div class="container-fluid" id ="content-tshirt" >
        <div class="row content">
            <div class="col-sm-6 sidenav" id ="sidbar">
                <form action="voteTshirt" method="post">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Miage</th>
                            <th>Pays Associé</th>
                            <th>Image Associée</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach  var="t" items="${requestScope['concour']}">

                            <tr>
                                <td>${t.miage}</td>
                                <td>${t.pays}</td>
                                <td><img src="${t.urlphoto}"/></td>
                                <td>  <label><input type="radio" name="typeTshirt" value="${t.id}" required></td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
                      <input type="submit" value="Valider" name="submit" class="btn btn-default"/>
                </form>
            </div>
            <div class="col-sm-6" id ="contenuVideo">

            </div>
        </div>
    </div>





</c:if> 

