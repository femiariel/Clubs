<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<nav class="navbar navbar-expand-lg">
	<div class="container-fluid">
  <div class="d-flex align-items-center">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex flex-row">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Accueil</a>
        </li>
        <li class="nav-item">
          <select class="form-select" onchange="window.location.href = this.value;">
            <option value="">Rechercher en fonction de:</option>
            <option value="./ServClub">région et fédération</option>
            <option value="./ServRayon">rayon</option>
            <option value="./ServClubRegion">region</option>
          </select>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ServVisua">Visualiser le nombre de  licenciés</a>
        </li>
      </ul>
    </div>
  </div>
</div>
	
	<div class="container-fluid d-flex justify-content-center flex-row col-4">
		<a class="navbar-brand mx-auto" href="#">
			<h1>Clubs de sport</h1>
		</a>
	</div>
	<div class="d-grip gap-2 col-4" style="text-align:right;margin-right: 1em">
		<a type="button" class="btn btn-outline-secondary" href="./InscriptionServlet" id="acceder_aux_comptes">
			Inscription
		</a>
		<a type="button" class="btn btn-outline-secondary" href="connexion.jsp" id="acceder_aux_comptes">
			Connexion
		</a>
	</div>
</nav>