<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Publique</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
		
		<style>
		/*body{
			background-image: url("images/image_sports_1.png");
  			background-size: cover; /*pour ajuster la taille de l'image à la taille de la page*/
  			background-repeat: no-repeat; /*pour ne pas répéter l'image*/
 
		}
		.carousel-item {
 			 position: absolute;
  			z-index: 1; /* la valeur z-index doit être supérieure à celle des autres éléments pour s'afficher au-dessus*/
}
header{
 background-color: rgba(0, 0, 0, .25);}
body {
  /*font-size: .875rem;*/
}

.feather {
  width: 16px;
  height: 16px;
}

/*
 * Sidebar
 */

.sidebar {
  position: fixed;
  top: 0;
  /* rtl:raw:
  right: 0;
  */
  bottom: 0;
  /* rtl:remove */
  left: 0;
  z-index: 100; /* Behind the navbar */
  padding: 80px 0 0; /* Height of navbar */
  box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
}

@media (max-width: 767.98px) {
  .sidebar {
    top: 5rem;
  }
}

.sidebar-sticky {
  height: calc(100vh - 48px);
  overflow-x: hidden;
  overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
}

.sidebar .nav-link {
  font-weight: 500;
  font-size: 14px;
  color: #333;
}


.sidebar select{
font-size: 14px;
}

.sidebar .nav-link .feather {
  margin-right: 4px;
  color: #727272;
}

.sidebar .nav-link.active {
  color: #2470dc;
}

.sidebar .nav-link:hover .feather,
.sidebar .nav-link.active .feather {
  color: inherit;
}

.sidebar-heading {
  font-size: .75rem;
}

/*
 * Navbar
 */

.navbar-brand {
  padding-top: .75rem;
  padding-bottom: .90rem;
  /*background-color: rgba(0, 0, 0, .25);
   /* box-shadow: inset -1px 0 0 rgba(0, 0, 0, .25);*/
}

.navbar .navbar-toggler {
  top: .25rem;
  right: 1rem;
}

.navbar .form-control {
  padding: .75rem 1rem;
}

.form-control-dark {
  color: #fff;
  background-color: rgba(255, 255, 255, .1);
  border-color: rgba(255, 255, 255, .1);
}

.form-control-dark:focus {
  border-color: transparent;
  box-shadow: 0 0 0 3px rgba(255, 255, 255, .25);
}

		</style>
	</head>
	<body>
	<div class="row">
	<header class="navbar navbar-dark sticky-top flex-md-nowrap p-0 text-align-center shadow navbar-expand-lg">

	  <div class="container-fluid d-flex justify-content-center flex-row text-align-center" style="text-align:center">
		<a class="navbar-brand mx-auto" href="#">
			<h1>Clubs de sport</h1>
		</a>
	</div> 
	<div class="" style="text-align:right;margin-right: 1em">
		
		<a type="button" class="btn btn-outline-secondary" href="connexion.jsp" id="acceder_aux_comptes">
			Déconnexion
		</a>
	</div>
	 
	</header>
	</div>
	
	
 <div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-body-tertiary sidebar collapse">
      <div class="position-sticky pt-3 sidebar-sticky">
        <ul class="nav flex-column">
        
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="#page_elu.jsp">
              <span data-feather="home" class="align-text-bottom"></span>
              Accueil
            </a>
          </li>
          
            
            <li class="nav-item">
					<select onchange="window.location.href = this.value;">
					  <option value="">Rechercher en fonction de:</option>
					  <option value="./ServClub">région et fédération</option>
					  <option value="./ServRayon">rayon</option>
					  <option value="./ServClubRegion">region</option>
					</select>
				</li>
          
          
          <li class="nav-item">
            <a class="nav-link" href="Visualisationcommune.jsp">
              <span data-feather="file" class="align-text-bottom"></span>
             Consulter le nombre de licenciés(region, commune)
            </a>
          </li>
         
            
            
             <li class="nav-item">
					<select onchange="window.location.href = this.value;">
					  <option value="">Visualisation du classement:</option>
					  <option value="./ServProp">par commune</option>
					  <option value="./ServPropCommune">par region</option>
					</select>
				</li>
            
             <li class="nav-item">
            <a class="nav-link active" href="Page_consultation_elu.jsp">
              <span data-feather="file" class="align-text-bottom"></span>
              Consulter par tranche d'age
            </a>
          </li>
            
            <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file" class="align-text-bottom"></span>
              Telecharger les documents(format XLSX et/ou pdf)
            </a>
          </li>
          
         
        </ul>

      
      
      </div>
    </nav>
    
	 <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4" >
		
		
    

		<!--
		------------------------------------------------------- CONTENU DEBUT -------------------------------------------------------
		-->
		
		    
			<div class="container text-center" id="text_info_public">
				<div class="carousel carousel-dark slide justify-content-center" style:"carousel-dark-caption-opacity:100">
					<div class="carousel-inner">
		                <div class="carousel-item active">
		                
		<!--
		------------------------------------------------------- c'est ici qu'on insert son code -------------------------------------------------------
		-->
		
		<iframe id="mon-iframe" title="ps8" width="1140" height="541.25" src="https://app.powerbi.com/reportEmbed?reportId=3111627a-61a7-450b-904b-82ae3507e448&autoAuth=true&ctid=371cb156-9558-4286-a3cd-3059699b890c" frameborder="0" allowFullScreen="true"></iframe>
		
		
		
		
		
		                  			
		<!--
		------------------------------------------------------- FIN de l'insertion du code -------------------------------------------------------
		-->
		
		                </div>
					</div>
				</div>
			</div>
			
		<!--
		------------------------------------------------------- CONTENU FIN -------------------------------------------------------
		-->
		
	


	</main>
	</div>
    </div>
    
    
	</body>
</html>