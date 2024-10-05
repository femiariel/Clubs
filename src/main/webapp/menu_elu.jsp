<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<nav class="navbar navbar-expand-lg">
	<div class="container-fluid d-flex flex-row col-4">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon">
				
			</span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
				  <a class="nav-link active" aria-current="page" href="#">Accueil</a>
				</li>
				<li class="nav-item">
				  <select class="nav-link" onchange="navigateToUrl(this)">
				    <option value="./ServClub">Rechercher en fonction de région et fédération</option>
				    <option value="#">Vue Liste</option>
				    <option value="#">Vue Carte</option>
				  </select>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="#">licenciés par federation</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="Visualisation_classement.jsp">Visualisation du classement</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="#">Indicateur statistique</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="#">Exporter les données</a>
				</li>
			</ul>
		</div>
		
	</div>
	<div class="container-fluid d-flex justify-content-center flex-row col-4">
		<a class="navbar-brand mx-auto" href="#">
			<h1>Clubs de sport</h1>
		</a>
	</div>
	<div class="d-grip gap-2 col-4" style="text-align:right;margin-right: 1em">
		<a type="button" class="btn btn-outline-secondary" href="inscription.jsp" id="acceder_aux_comptes">
			Inscription
		</a>
		<a type="button" class="btn btn-outline-secondary" href="connexion.jsp" id="acceder_aux_comptes">
			Connexion
		</a>
	</div>
</nav>