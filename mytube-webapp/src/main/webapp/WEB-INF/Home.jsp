<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="reset.css">
<link rel="stylesheet" href="Home.css">
<title>MyTube</title>
</head>
<body>
    <div id="nav-horiz" >
            <ol class="menu-horiz">
                    <li><a class="menu-horiz__item" href="">Menu</a></li>
                    <li><a class="menu-horiz__item" href=""><img id="logo"src="images/my_tube.png"></a></li>
                    <li><div class="menu-horiz__item" href="" id="recherche">

                            <form >
                            <input  placeholder="Rechercher" />
                            <input id="format-loupe" >

                            </form>

                            
                            </div></li>
                    <li><a class="menu-horiz__item" href="">Mettre en ligne</a></li>
                    <li><a class="menu-horiz__item" href="">Applications</a></li>
                    <li><a class="menu-horiz__item" href="">Paramètres</a></li>
                    <li><a class="menu-horiz__item" href="">SE CONNECTER</a></li>
            </ol>
    </div>
    <div id="nav-verti" >
        <ol class="menu-verti">
            <li><a class="menu-verti__item" id="accueil" href="">Accueil</a></li>
            <li><a class="menu-verti__item" href="">Tendances</a></li>
            <li><a class="menu-verti__item" href="">Historique</a></li>
            <li><a class="menu-verti__item" id="theBest" href="">LE MEILLEUR DE YOUTUBE</a></li>
            <li><a class="menu-verti__item" href="">Musique</a></li>
            <li><a class="menu-verti__item" href="">Sport</a></li>
            <li><a class="menu-verti__item" href="">Jeux Vidéo et autres</a></li>
            <li><a class="menu-verti__item" href="">Films</a></li>
            <li><a class="menu-verti__item" href="">Emissions télévisées</a></li>
            <li><a class="menu-verti__item" href="">Actualités</a></li>
            <li><a class="menu-verti__item" href="">En direct</a></li>
            <li><a class="menu-verti__item" href="">360° Video</a></li>
        </ol>
    </div>
    <section id="conteneur">
            <div class="ligne-video">
                <h1>Tendances</h1>
                <div class="element" >
                	<c:forEach items="${trendingVideoList}" var="item">
                	<div class="video">
                	<video class="format-video" src="${item.url}" autoplay poster="${item.capture}" href="http://localhost:8080/MyTubeWebProject/VideoPage"></video>                	
  					</div>
					</c:forEach>     
                </div>
            </div>
            <div class="ligne-title"> 
            	<c:forEach items="${trendingVideoList}" var="item">
                	<div class="video">
                		<h2>${item.title}</h2>
  					</div>
				</c:forEach>
            </div>
        <div class="ligne-video">
            <h1 class="title">Recommandations</h1>
                           <div class="element" >
                	<c:forEach items="${recommendedVideoList}" var="item">
                	<div class="video">
                	<video class="format-video" src="${item.url}" autoplay poster="${item.capture}" href="http://localhost:8080/MyTubeWebProject/VideoPage"></video>                	
  					</div>
					</c:forEach>     
                </div>
            </div>
            <div class="ligne-title"> 
            	<c:forEach items="${recommendedVideoList}" var="item">
                	<div class="video">
                		<h2>${item.title}</h2>
  					</div>
				</c:forEach>
            </div>
        </div>
        <!-- <div class="ligne-video">
            <h1 class="title">Videos mises en ligne récemment</h1>
            <div class="element" >   
                <div class="video">
                        <iframe class="format-video" src="https://www.youtube.com/embed/5VjC0KerJCI" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
                </div>
                <div class="video">
                </div>
                <div class="video">
                </div>
                <div class="video">
                </div>
                <div class="video">
                </div>     
            </div>
        </div> -->
    </section>
</body>
</html>