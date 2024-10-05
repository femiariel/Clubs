<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.esigelec.jee.*"%>
<%@ page import="fr.esigelec.model.*"%>

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
		
		
		
		<form method="post" action="Modif_infos_acteur">
		
			<% int id = Integer.parseInt(request.getParameter("id")); 
			String titre = request.getParameter("titre");
			String contenu = request.getParameter("contenu");%>
			
			<div id="body_acteurs" style="background-color:lightgoldenrodyellow;margin:3em;border-radius:10px">
			    <h2 style="text-align: center;background-color: gold;margin-left: 12em;margin-right: 12em;border-radius:10px">
			        Informations actuelles Modification
			    </h2>
			    
			    <h3 style="margin-left:3em">
			    	Modifications
			    </h3>
			    <h4 style="margin-left:3em" id="titre">
	        		<%=titre %>
			    </h4>
			    <p style="margin-left:1.25em;margin-right:1.25em" id="contenu">
			        <%=contenu %>
			    </p>
			    <label for="txtTitre" class="form-label" style="margin-left:3em">
			    	Titre :
			    </label>
			    <input id="txtTitre" name="txtTitre" class="form-control"/>
			    <label for="txtContenu" class="form-label" style="margin-left:3em">
			    	Informations :
			    </label>
			    <textarea id="txtContenu" name="txtContenu" class="form-control" rows="3"></textarea>
			    <input type="hidden" name="id" value="<%=id %>">
			    <script>
				    var titre = document.getElementById('titre').textContent.trim();
			    	var contenu = document.getElementById('contenu').textContent.trim();
			    	var txtTitre = document.getElementById('txtTitre');
			    	var txtContenu = document.getElementById('txtContenu');
			    	txtTitre.value = titre;
			    	txtContenu.value = contenu;
			    </script>
			    
			</div>
			<button type="submit" class="btn btn-outline-success mb-3 ms-auto">Modifier</button>
			
		</form>
		<a class="btn btn-outline-danger mb-3" href="page_acteur_monde_sportif.jsp" role="button">Annuler</a>
	</body>
</html>