<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function redirectToPage() {
      window.location.href = "https://www.example.com";
    }
  </script>
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <h1>Clubs de sport</h1>
        </a>
        <div class="collapse navbar-collapse">
	        <ul class="navbar-nav flex-row flex-wrap ms-auto">
	    		<li class="nav-item">
	    		<a style="font-weight: bold; font-size: 24px; color: White;">
    				[<%= session.getAttribute("prenom") %> <%= session.getAttribute("nom") %>]
				</a>

		   			<br/>
		            
	            </li>
	            <li class="nav-item dropdown">
	    			<a class="nav-link dropdown-toggle ms-auto" href="#" role="button" data-bs-toggle="dropdown">
		                <img src="images/account.png">
		            </a>
		            <ul class="dropdown-menu dropdown-menu-end">
		                <li><a class="dropdown-item" href="./ServletDeconnexion">Déconnexion</a></li>
		            </ul>
	    		</li>
	    	</ul>
        </div>
    	
    </div>
</nav>

<nav class="navbar navbar-expand-lg">
	<div class="container">
 
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #CCCCCC;">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Mon site</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="page_acteur_monde_sportif.jsp">Accueil</a>
          </li>
          <li class="nav-item">
            <select class="form-select" style="background-color: #f2f2f2;" onchange="window.location.href = this.value;">
              <option value="">Rechercher en fonction de:</option>
              <option value="./ServClub">région et fédération</option>
              <option value="./ServRayon">rayon</option>
              <option value="./ServClubRegion">region</option>
            </select>
          </li>
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="ServVisua">Visualiser le nombre de licenciés</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="page_acteur_ajouter.jsp">Ajouter des informations</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</div>
	
</nav>