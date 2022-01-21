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
        <script src="./front/js/book-room-p1.js"></script>
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

    <div class="ui grid">

    <div class="four wide column"></div>

    <div class="eight wide column">
    
         <form id="data-form" class="ui form" action="/booking/book-room-p2" method="POST">
            <div class="ui floating message"> 
            <br/>
            <div id="begin-date-field" class="field">
              <label>Date de début</label>
              <div class="ui calendar" id="date-calendar">
                <div class="ui input left icon">
                  <i class="calendar icon"></i>
                  <input id="begin-date" type="text" name="begin-date" placeholder="Date de début">
                </div>
              </div>
            </div>
            <br/>
            <div id="end-date-field" class="field">
              <label>Date de fin</label>
              <div class="ui calendar" id="date-calendar">
                <div class="ui input left icon">
                  <i class="calendar icon"></i>
                  <input id="end-date" type="text" name="end-date" placeholder="Date de fin">
                </div>
              </div>
            </div>
            <br/>
            </div>
          </form>    
	
	</div>

    <div class="four wide column"></div>
       
    </div>
    
    <div class="ui grid">

      <div class="four wide column"></div>
      
      <div class="eight wide column">
  
          <button onclick="submitForm()" style="background-color: #2596be; color: white; height: 50px;" class="fluid ui button" type="submit">Suivant</button>

      </div>


      <div class="four wide column"></div>

    </div>
</body>

</html>