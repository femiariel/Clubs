<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Visualisation du classement</title>
		<link rel="stylesheet" type="text/css" href="style_elu.css">
        <link rel="shortcut icon" type="image/png" href="images/favicon.png"/>		
      <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
</head>
<body>
	<header>
	<div class="container">
		<div class="left">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item">
							  <a class="nav-link active" aria-current="page" href="#">Accueil</a>
							</li>
							<li class="nav-item">
							  <select class="nav-link" onchange="navigateToUrl(this)">
							    <option value="0">Rechercher en fonction de:</option>
							 	<option value="1">région et fédération</option>
							    <option value="2">rayon</option>
							    <option value="3">region</option>
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
		
		
	
		
			<div class="centre">
				    <div class="container-fluid d-flex justify-content-center flex-row col-4">
						<a class="navbar-brand mx-auto" href="#">
							<h1> Clubs de sport </h1>
						</a>
					</div>
			</div>	
				
				
				
				
				
		   <div class="right">
	        
	        
	        <div class="top">
	       		<li class="nav-item">
	    			<a class="nav-link dropdown-toggle ms-auto" href="#" role="button" data-bs-toggle="dropdown">
		                <img src="images/account.png">
		            </a>
	    			<p style="font-size: 12px; color: White; padding-bottom:1%;;">[Prénom NOM]</p>
	            </li>
	        </div>
	        
	        <div class="bottom">
	       		<li class="nav-item dropdown">
		            <ul class="dropdown-menu dropdown-menu-end">
		                <li><a class="dropdown-item" href="page_grand_publique.jsp">Déconnexion</a></li>
		            </ul>
	    		</li>
	        </div>
	        
		</div>
	</div>	
</header>

	<iframe title="visu" width=100% height="600" src="https://app.powerbi.com/reportEmbed?reportId=0d128989-7f0d-4f7f-a6a5-caaefe1d80e5&autoAuth=true&ctid=371cb156-9558-4286-a3cd-3059699b890c" frameborder="0" allowFullScreen="true"></iframe>
</body>
</html>