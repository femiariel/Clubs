<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.esigelec.jee.*"%>
<%@ page import="fr.esigelec.model.*"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Acteur</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
	</head>
	<body>
	<%@ include file="menu_prive.inc.jsp" %>
	
	<%  
    InfosActeurDAO infosActeurDAO = new InfosActeurDAO();
    String federation = (String) session.getAttribute("federation");
    String commune = (String) session.getAttribute("commune");
    ArrayList<ActeurInfos> list = infosActeurDAO.getInfos(commune,federation); 
    %>
	
	
	<div id="body_acteurs" style="background-color:lightgoldenrodyellow;margin:3em;border-radius:10px">
	    <h2 style="text-align: center;background-color: gold;margin-left: 15em;margin-right: 15em;border-radius:10px">
	        Informations actuelles
	    </h2>
	    <table class="table">
	    	<tbody>
	    			
		    	<% for (int i=0;i<list.size();i++){ %>
		    	
			    	<tr>
			    		<td>
						    <h3 style="margin-left:3em" id="txtTitre_<%=i%>">
						        <%= list.get(i).getTitre() %>
						    </h3>
						    <p style="margin-left:1.25em;margin-right:1.25em" id="txtContenu_<%=i%>">
						        <%= list.get(i).getInformations() %>
						    </p>
						</td>
						<td>
				   			<a class="nav-link" aria-current="page" href="page_acteur_modifier.jsp?id=<%= list.get(i).getId() %>&titre=<%= list.get(i).getTitre() %>&contenu=<%= list.get(i).getInformations() %>">
				   				Modifier ces informations
				   			</a>
			    		</td>
			    	</tr>
			    	
				<% } %>
			    
	    	</tbody>
		    
		    
	    </table>
	</div>


	</body>
</html>