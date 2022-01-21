<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
        <meta charset="utf-8" />
        <title>Affichage des chambres</title>
        <link rel="stylesheet" type="text/css" href="./front/lib/semantic-ui/semantic.min.css">
        <link rel="stylesheet" type="text/css" href="./front/lib/data-tables/dataTables.semanticui.min.css">
        <script src="./front/lib/jquery/jquery-3.1.1.min.js"></script>
        <script src="./front/lib/data-tables/jquery.dataTables.min.js"></script>
        <script src="./front/lib/data-tables/dataTables.semanticui.min.js"></script>
        <script src="./front/lib/semantic-ui/semantic.min.js"></script>
        <script src="./front/js/display-statistics.js"></script>
</head>

<body>

    <!-- Le menu de navigation de la page -->
    <div style="background-color: #2596be; overflow: hidden;">
      <div style="background-color: #2596be" class="ui inverted segment">
        <div style="border:1px solid #2596be;" class="ui inverted secondary pointing top menu">
          <a onclick="redirect('customers')" class="item">
            <i class="male large icon"></i>
            Utilisateurs
          </a>
          <a onclick="redirect('rooms')" class="item">
            <i class="bed large icon"></i>
            Chambres
          </a>
          <a onclick="redirect('reservations')" class="item">
            <i class="address book outline large icon"></i>
            Réservations
          </a>
          <a onclick="redirect('statistics')" class="active item">
            <i class="chart bar large icon"></i>
            Statistiques
          </a>
          <div class="right menu">
            <a onclick="redirect('disconnection')" class="item">
              <i class="power off large icon"></i>
            </a>
          </div>
        </div>
      </div>
    </div>
    
    <br/><br/>
    

    <!-- ********************************* -->

    <div class="ui grid">

    <div class="five wide column"></div>

    <div class="six wide column">
	    
	<div style="text-align: center"  class="ui floating message"> 
		<div class="ui statistic">
		  <div class="label">
		    Clients
		  </div>
		  <div class="value">
		     3
		  </div>
		</div>
	</div>

	 <br/>    <div class="ui horizontal divider">AND</div>
	    
	</div>

    <div class="five wide column"></div>

    </div>
    

    <!-- ********************************* -->

    <div class="ui grid">

    <div class="five wide column"></div>

    <div class="six wide column">
	    
	<div style="text-align: center"  class="ui floating message"> 
		<div class="ui statistic">
		  <div class="label">
		    Chambres
		  </div>
		  <div class="value">
		   4
		  </div>
		</div>
	</div>
	
	<br/> <div class="ui horizontal divider">AND</div>

	    
	</div>

    <div class="five wide column"></div>

    </div>



    <!-- ********************************* -->

    <div class="ui grid">

    <div class="five wide column"></div>

    <div class="six wide column">
	    
	<div style="text-align: center" class="ui floating message"> 
		<div class="ui statistic">
		  <div class="label">
		    Chiffre d'affaire
		  </div>
		  <div class="value">
		    3450,85 DH
		  </div>
		</div>
	</div>
	    
	</div>

    <div class="five wide column"></div>

    </div>
    
</body>

</html>