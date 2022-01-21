<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
	<head>
	  <meta charset="ISO-8859-1">
	  <title>Login</title>
	  <link rel="stylesheet" type="text/css" href="./front/lib/semantic-ui/semantic.min.css">
	  <link rel="stylesheet" type="text/css" href="./front/css/login.css">
	  <script src="./front/lib/jquery//jquery-3.1.1.min.js"></script>
	  <script src="./front/lib/semantic-ui/semantic.min.js"></script>
	  <script src="./front/js/login.js"></script>
	</head>

	<body>
	
	<!-- Affichage du formulaire -->
	<div class="ui middle aligned center aligned grid">
	  <div style="background-color: white; border-radius: 5px;" class="column">
	    <form class="ui large form" action="/booking/login" method="POST">
	      <div class="ui floating message">
	        <br/>
	        <div class="field">
	          <div class="ui left icon input">
	            <i class="user icon"></i>
	            <input type="text" name="login" placeholder="Adresse email" value="${login}">
	          </div>
	        </div>
	        <div class="field">
	          <div class="ui left icon input">
	            <i class="lock icon"></i>
	            <input type="password" name="password" placeholder="Mot de passe">
	          </div>
	        </div>
	        <br/>
	        <button class="ui button" type="submit">Connexion</button>
	        <br/>     
	      </div>
	      <div class="ui error message"></div>
	      <div class="ui error message" style ="display:${loginDisplayErrorMsg}">
	        Utilisateur inconnu ou mot de passe incorret
	      </div>
	      <div class="ui error message" style ="display:${inactiveUserErrorMsg}">
	        Utilisateur inactif
	      </div>	
	      <br/>
	        <div class="ui horizontal divider">Ou</div>
	      <br/>
	
	      <div style="padding: 15px;" onclick="redirect('/booking/create-customer')" class="ui teal labeled icon button">
	        Créer un nouveau compte client
	        <i class="add icon"></i>
	      </div>
	
	    </form>
	  
	  </div>
	
	</div>
	
	</body>

</html>