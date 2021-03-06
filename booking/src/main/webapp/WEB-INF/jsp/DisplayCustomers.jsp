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
        <script src="./front/js/display-customers.js"></script>
</head>

<body>

    <!-- Le menu de navigation de la page -->
    <div style="background-color: #2596be; overflow: hidden;">
      <div style="background-color: #2596be" class="ui inverted segment">
        <div style="border:1px solid #2596be;" class="ui inverted secondary pointing top menu">
          <a onclick="redirect('customers')" class="active item">
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
          <a onclick="redirect('statistics')" class="item">
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
    
    <form id="data-form" class="ui form" action="/booking/activate-user" method="POST">
        <input id="userID" type="hidden" name="userID" >
    </form> 

    <div style="overflow: auto;" class="ui grid">

    <div class="one wide column"></div>

    <div style="overflow: auto;" class="fourteen wide column">
    
		<table id="users-table" class="ui celled table" style="width:100%;text-align: center;">
			<thead>
				<tr>
					<th></th>
					<th>ID</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Actif</th>
					<th>Rôle</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${users}">
					<tr>
						<td>
							<c:if test="${u.state == false}" var="variable">
		  						<button id="${u.id}" style="background-color: #2596be; color: white;" onclick="activateUser(this.id)" class="ui icon button">
		  						<i class="thumbs up outline icon"></i>
								</button>
							</c:if>
						</td>
						<td>${u.id}</td>
						<td>${u.firstname}</td>
						<td>${u.lastname}</td>
						<td>${u.state}</td>
						<td>${u.role}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	    </div>

    <div class="one wide column"></div>

    </div>
</body>

</html>