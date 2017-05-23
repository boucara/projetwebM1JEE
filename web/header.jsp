<%-- 
    Document   : header
    Created on : 22 mai 2017, 14:18:18
    Author     : Aicha
--%>

<!-- Navbar -->
<nav class="navbar navbar-fixed-top">
    <a href="http://miageprojet2.unice.fr/">  
        <img src="${pageContext.request.contextPath}/resources/images/logo_miage.png"/>  
    </a>  
    <a href="http://unice.fr/">  
        <img src="${pageContext.request.contextPath}/resources/images/logo_uns.png"/>  
    </a>  
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
            </button>
            <a class="navbar-brand" href="#">JNM 2018</a>
        </div>
        <div class="collapse navbar-collapse" id="menu">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#myPage">HOME</a></li>
                <li><a href="#band">Informations pratiques</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Activités
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Concours</a></li>
                        <li><a href="#">Vidéos</a></li>
                        <li><a href="#">T-Shirt</a></li> 
                        <li><a href="#">Soirée</a></li> 
                        <li><a href="#">Gala</a></li> 
                        <li><a href="#">Europa Pack</a></li> 
                    </ul>
                </li>
                <li><a href="#tour">Se connecter</a></li>
                <li><a href="#contact">Participer</a></li>

                
            </ul>
        </div>
    </div>
</nav>

