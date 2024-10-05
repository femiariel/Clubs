<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Acteur</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
	</head>
	<body>
		<%@ include file="menu_prive.inc.jsp" %>
		
		<h2 style="text-align: center">Ajouter des informations</h2>
		
		<form method="post" action="./Ajout_infos_acteur">
			<div class="mb-3">
				<label for="titreAjouter" class="form-label">Titre</label>
				<input class="form-control" id="titreAjouter" name="titreAjouter" placeholder="Titre">
			</div>
			<div class="mb-3">
				<label for="infosAjouter" class="form-label">Informations</label>
				<textarea class="form-control" id="infosAjouter" name="infosAjouter" rows="3"></textarea>
			</div>
			<input type="hidden" name="mairie" value="${sessionScope.commune }">
			<input type="hidden" name="federation" value="${sessionScope.federation }">
			<button type="submit" class="btn btn-outline-success mb-3">Ajouter</button>
		</form>
		
	</body>
</html>