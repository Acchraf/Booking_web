<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link rel="stylesheet" type="text/css" href="./front/lib/semantic-ui/semantic.min.css">
        <link rel="stylesheet" type="text/css" href="./front/lib/data-tables/dataTables.semanticui.min.css">
        <script src="./front/lib/jquery/jquery-3.1.1.min.js"></script>
        <script src="./front/lib/semantic-ui/semantic.min.js"></script>
        <script src="./front/lib/semantic-ui/components/calendar.min.js"></script>
        <script src="./front/js/create-customer.js"></script>
</head>

<body>
    
    <br/><br/>

    <div class="ui grid">

    <div class="three wide column"></div>

    <div class="ten wide column">
    
          <form class="ui form" action="/booking/create-customer" method="POST">
         	<div class="ui floating message"> 
	            <div id="login-field" class="field">
	              <label>Email</label>
	              <input type="text" name="email" placeholder="Email" value="" >
	            </div>
	            <div class="field">
	              <label>Prénom</label>
	              <input style="text-transform: uppercase" type="text" name="first-name" placeholder="Prénom" value="">
	            </div>
	            <div class="field">
	              <label>Nom</label>
	              <input style="text-transform: uppercase" type="text" name="last-name" placeholder="Nom" value="" >
	            </div>
	            <div class="field">
	              <label>Password</label>
	              <input type="password" name="password" placeholder="Password" value="" >
	            </div>
	          	<br/>
	        	<button style="margin:auto;" class="ui button" type="submit">Créer</button>
        	</div>
          </form>
          
     </div>
          
     <div class="three wide column"></div>
          
     </div>

</body>

</html>