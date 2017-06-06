<%-- 
    Author     : Tom
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>   

<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   




<!-- Message qui s'affiche lorsque la page est appelé avec un paramètre http message -->  
<c:if test="${!empty requestScope['message']}">  
    <h2>Reçu message : ${param.message}</h2>  
</c:if> 

<!-- Zone qui affiche les Etudiants si le paramètre action vaut listerLesEtudiants -->  
<c:if test="${requestScope['action'] == 'listerLesEtudiants'}" >  
    <h2>Liste des Etudiants</h2>  

    <table border="10" class="table">  
        <!-- La ligne de titre du tableau des adresses -->  
        <thead>
            <tr>  
                <td><b>Email</b></td>  
                <td><b>Nom</b></td>  
                <td><b>Prenom</b></td>
                <td><b>Miage</b></td>
                <td><b>Passeword</b></td>
                <td><b>Confirm Passeword</b></td>
                <td><b></b></td>
            </tr>  
        </thead>

        <!-- Ici on affiche les lignes, une par adresse -->  
        <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
        <c:set var="total" value="0"/>  
        <tbody>
            <c:forEach var="e" items="${requestScope['listeEtudiants']}">  
                <c:if test="${e != null}"> 
                    <tr>
                <form action="GestionUtilisateur" method="post">
                    <td><input type="text" name="nom" value="${e.email}" disabled/></td>  
                    <td><input type="text" name="nom" value="${e.nom}"/></td>  
                    <td><input type="text" name="prenom"  value="${e.prenom}"/></td>
                    <td><input type="text" name="vilEtu" value="${e.vilEtu}"/></td>
                    <input type="hidden" name="action" value="updateEtudiant"/>
                    <td><input type="submit" value="Mettre à jour" name="submit"/></td>
                </form>
                <td><a href="GestionUtilisateur?action=deleteEtudiant&pagination=${i*10}&idEtudiant=${e.id}">Supprimer</a></td>
                <td></td>
                <c:set var="total" value="${total+1}"/>
                <!-- On compte le nombre d'adresses -->  

            </tr>  
        </c:if> 
    </c:forEach> 
    <tr><form action="GestionUtilisateur" method="post">
        <td><input type="email" name="email"/></td>  
        <td><input type="text" name="nom" /></td>  
        <td><input type="text" name="prenom"  /></td>
        <td><input type="text" name="vilEtu" /></td>
        <td><input type="password" name="mdp" /></td>
        <td><input type="password" /></td>
        <input type="hidden" name="action" value="ajouterEtudiant"/>
        <td><input type="submit" value="ajouter" name="submit"/></td></form></tr>


<!-- Affichage du solde total dans la dernière ligne du tableau -->  
<tr><td><b>TOTAL</b></td><td></td><td></td><td></td><td></td><td></td><td><b>${total}/${requestScope['nombreEtudiants']}</b></td></tr> 
</tbody>
</table>  
<ul class="pagination">
    <c:forEach var="i" begin="0" end="${requestScope['nombreEtudiants']/10}">
        <li><a href="GestionUtilisateur?action=listerLesEtudiants&pagination=${i*10}">${i}</a></li>
        </c:forEach>
</ul>
</c:if> 
    
</div>





