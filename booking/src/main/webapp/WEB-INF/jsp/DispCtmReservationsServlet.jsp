<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
        <meta charset="utf-8" />
        <title>Affichage des clients</title>
        <link rel="stylesheet" type="text/css" href="./front/lib/semantic-ui/semantic.min.css">
        <link rel="stylesheet" type="text/css" href="./front/lib/data-tables/dataTables.semanticui.min.css">
        <script src="./front/lib/jquery/jquery-3.1.1.min.js"></script>
        <script src="./front/lib/data-tables/jquery.dataTables.min.js"></script>
        <script src="./front/lib/data-tables/dataTables.semanticui.min.js"></script>
        <script src="./front/lib/semantic-ui/semantic.min.js"></script>
        <script src="./front/js/customer-reservations.js"></script>
</head>

<body>

    <!-- Le menu de navigation de la page -->
    <div style="background-color: #2596be; overflow: hidden;">
      <div style="background-color: #2596be" class="ui inverted segment">
        <div style="border:1px solid #2596be;" class="ui inverted secondary pointing top menu">
          <a onclick="redirect('customer-reservations?id=${sessionScope.customerID}')" class="active item">
            <i class="address book outline large icon"></i>
            Réservations
          </a>
          <a onclick="redirect('book-room')" class="item">
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

    <div style="overflow: auto;" class="ui grid">

    <div class="one wide column"></div>

    <div style="overflow: auto;" class="fourteen wide column">
    
		<table id="users-table" class="ui celled table" style="width:100%;text-align: center;">
			<thead>
				<tr>
					<th>N° Chambre</th>
					<th>Début</th>
					<th>Fin</th>
				    <th>Prix</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="r" items="${customerReservations}">
					<tr>
						<td>${r.room.number}</td>
						<td>${r.beginDate}</td>
						<td>${r.endDate}</td>
						<td>${r.price} DH</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	    </div>

    <div class="one wide column"></div>

    </div>
</body>

</html>