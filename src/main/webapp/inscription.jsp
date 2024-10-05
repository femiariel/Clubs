<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Hugo 0.104.2">
	<title>page d'inscription</title>
	
	<link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
	
      <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
	
	<!-- Custom styles for this template -->
	<link href="style-inscription.css" rel="stylesheet">
	<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
	</head>
	
	<body >
	
		<main class="form-signin w-100 m-auto">
			<form action="InscriptionServlet" method="post">
				<h1 class="h3 mb-3 fw-normal">Entrez vos informations</h1>
				<h1 class="h3 mb-3 fw-normal">Nom :</h1>
				<div class="form-floating">
					<input type="Nom" class="form-control" id="floatingInput" placeholder="Nom"  name="le_nom" required="required"><br>
				</div>
				
				
				<h1 class="h3 mb-3 fw-normal">Prenom :</h1>
				<div class="form-floating">
					<input type="Prenom" class="form-control" id="floatingInput" placeholder="Prenom"   name="le_prenom" required="required"><br>
				</div>
				
				
				<h1 class="h3 mb-3 fw-normal">Email :</h1>
				<div class="form-floating">
					<input type="email" class="form-control" id="floatingInput" placeholder="name@example.com"  name="l_email" required="required"><br>
				</div>
				
				
				<h1 class="h3 mb-3 fw-normal">Password :</label>
				<div class="form-floating">
					<input type="password" class="form-control" id="floatingPassword" placeholder="Password"   name="le_pass" required="required"><br>
				</div>
				
				
				<h1 class="h3 mb-3 fw-normal">Role :</h1>
				<div class="form-floating">
					<select id="role" name="choix_role" class="form-control mx-2" required="required">
						<option selected="selected" value="0">-Role désiré-</option>
						<option value="1">Elus (maires, député)</option>
						<option value="2">Acteur du monde sportif</option>
					</select>
				</div>
				<br>
				
				
				
				<h1 class="h3 mb-3 fw-normal">Region :</h1>
				<div class="form-floating">
					<select name="Region" id="Region">
	        			 <c:forEach var="item" items="${clubx}">
	          				  <option value="${item.region}">${item.region}</option>
	       				 </c:forEach>
	      			 </select>
				</div>
				<br>
				
				
				<h1 class="h3 mb-3 fw-normal">Federation :</h1>
				<div class="form-floating">
				    <select name="Federation" id="Federation">
				    <option value="">--Si vous etes un élu, laissez cette case vide--</option>
	         			 <c:forEach var="item" items="${clubv}">
	            			<option value="${item.nomFederation}">${item.nomFederation}</option>
	        			 </c:forEach>
	     			</select>
				</div>
				<br>
				
				
				
				<h1 class="h3 mb-3 fw-normal">Commune :</h1>
				<div class="form-floating">
				    <select name="Commune" id="Commune">
	         			 <c:forEach var="item" items="${clubos}">
	            			<option value="${item.nomCommune}">${item.nomCommune}</option>
	        			 </c:forEach>
	     			</select>
				</div>
				<br>
				
				
					
				
				<div class="bout ">
				<button class="w-100 m-auto btn btn-lg btn-primary" onclick="return confirm('Voulez vous vraiment envoyer le formulaire ?');" type="submit"><h5 class="text-center m-auto">Enregister  </h5></button>
				<p class="message">Vous possedez deja un compte? <a href="connexion.jsp">Connectez vous </a></p>
				<a href="page_grand_public.jsp">Retour a la page d'accueil</a>
				</div>
			 
			</form>
		</main>
		 <script>
    $(document).ready(function() {
      $('#Region').select2();
    });
    
    $(document).ready(function() {
        $('#Federation').select2();
      });
    $(document).ready(function() {
        $('#Commune').select2();
      });
  </script>
	
	</body>
</html>