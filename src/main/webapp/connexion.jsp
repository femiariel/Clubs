<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
		<meta name="generator" content="Hugo 0.104.2">
		
		<title>Page de connexion</title>
		<link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
		
		<!-- Custom styles for this template -->
		<link href="Style_connexion.css" rel="stylesheet" type="text/css">
		<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
	</head>
	
	<body>
		<form class="form-signin w-100 m-auto text-center" action="./connexionServlet" name='form_connexion' method='POST' >
			<h1 class="h3 mb-3 fw-normal"> Connexion </h1>
			<!-- <label class="title1" for="floatingInput">Email address</label> -->
			<div class="form-floating">
				<input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="l_mail" required="required">   <br>  
			</div>
			<!-- <label class="title1" for="floatingPassword">Password</label>-->
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="le_pass" required="required">
			</div>
			
			<div class="checkbox mb-3">
				<button class="w-100 btn btn-lg btn-primary text-center" type="submit"><h5 class="text-center m-auto">Se connecter </h5></button>
				<p class="message">Vous n'avez pas de compte? <a href="./InscriptionServlet">S'inscrire </a></p><br>
				<a href="page_grand_public.jsp">Retour a la page d'accueil</a>
			</div>
		</form>
	
	</body>
</html>