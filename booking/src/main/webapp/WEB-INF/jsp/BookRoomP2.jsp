<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
        <meta charset="utf-8" />
        <title>Affichage des clients</title>
        <link rel="stylesheet" type="text/css" href="./front/lib/semantic-ui/semantic.min.css">
        <link rel="stylesheet" type="text/css" href="./front/lib/semantic-ui/components/calendar.min.css">
        <script src="./front/lib/jquery/jquery-3.1.1.min.js"></script>
        <script src="./front/lib/semantic-ui/semantic.min.js"></script>
        <script src="./front/lib/semantic-ui/components/calendar.min.js"></script>
        <script src="./front/js/book-room-p2.js"></script>
</head>

<body>

     <!-- Le menu de navigation de la page -->
    <div style="background-color: #2596be; overflow: hidden;">
      <div style="background-color: #2596be" class="ui inverted segment">
        <div style="border:1px solid #2596be;" class="ui inverted secondary pointing top menu">
          <a onclick="redirect('customer-reservations?id=${sessionScope.customerID}')" class="item">
            <i class="address book outline large icon"></i>
            Réservations
          </a>
          <a onclick="redirect('book-room')" class="active item">
            <i class="bed large icon"></i>            
            Réserver une chambre
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

         <form id="data-form" class="ui form" action="/booking/create-reservation" method="POST">
            <input id="begin-date" type="hidden" name="begin-date" value="${beginDate}">            
            <input id="end-date" type="hidden" name="end-date" value="${endDate}">
            <input id="customer" type="hidden" name="customer" value="${sessionScope.customerID}">
            <input id="room" type="hidden" name="room">
            <input id="price" type="hidden" name="price">
          </form>   
    
     <div class="ui grid">

      <div class="four wide column"></div>
      
      <div class="three wide column">
	 	<div class="ui floating message">
	 	  <div class="header">Début</div>
	 	   ${beginDate}
	 	</div> 
      </div>

      <div class="one wide column"></div>

      
      <div class="three wide column">
	 	<div class="ui floating message">
	 	  <div class="header">Fin</div>
	 	   ${endDate}
	 	</div> 
      </div>

      <div class="one wide column"></div>

      <div class="four wide column"></div>

    </div>
    
    <div class="ui grid">

    <div class="four wide column"></div>

    <div class="eight wide column">
 	

<div class="ui link cards">

	<c:forEach var="rm" items="${rooms}">

	  <div id="${rm.id}-${rm.price}" onClick="persistReservation(this.id)" class="card">
	    <div class="image">
	      <img src="${rm.photo}">
	    </div>
	    <div class="content">
	      <div class="header">${rm.type} / ${rm.price} DH</div>
	      <div class="meta">
	        <a>${rm.type}</a>
	      </div>
	      <div class="description">
	        Lit très confortable et salle de bain privative
	      </div>
	    </div>
	    <div class="extra content">
	      <span class="right floated">
	        Rénovée en 2019
	      </span>
	      <span>
	        <i class="bed icon"></i>
	        N° ${rm.number}
	      </span>
	    </div>
	  </div>
				
	</c:forEach> 
  
</div> 	   
 
	
	</div>

    <div class="four wide column"></div>
       
    </div>
    
</body>

</html>