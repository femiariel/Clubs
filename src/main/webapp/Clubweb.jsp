<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="ISO-8859-1">
   <title>Insert title here</title>
   <link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.3/dist/leaflet.css"
     integrity="sha256-kLaT2GOSpHechhsozzB+flnD+zUyjE2LlfWPgU04xyI="
     crossorigin=""/>
    <link href="style_back.css" rel="stylesheet">
    
    
      <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
    <link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
</head>
<body> 
   <div id="maCarte"></div>
    
    
    
    
    <!-- Fichier Javascript -->
      <script src="https://unpkg.com/leaflet@1.9.3/dist/leaflet.js"
     integrity="sha256-WBkoXOwTeyKclOHuWtc+i2uENFpDZ9YPdf5Hf+D7ewM="
     crossorigin=""></script>    
     <script>
     // On initialise la  carte
        var carte = L.map('maCarte').setView([48.852969, 2.349903], 6);
     
     // On charge les tuiles
        var OpenStreetMap_France = L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
        	maxZoom: 20,
        	attribution: '&copy; OpenStreetMap France | &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        
        }).addTo(carte);
        <c:forEach var="item" items="${clubs}">
          console.log("Ajout du marqueur pour la commune " + "${item.nomCommune}");
          var marqueur = L.marker([${item.latitude}, ${item.longitude}]).addTo(carte);
          marqueur.bindPopup(`<b>${item.nomCommune}</b><br>${item.nomFederation}`);
          marqueur.on('click', function(e) {
            this.closePopup();
            this.openPopup();
          });
        </c:forEach>


        
        
        
     
     </script>
     
   <form method="post" action="./ServClub">
     <p>
      <label for="Region">Region:</label>
       <select name="Region" id="Region">
         <c:forEach var="item" items="${clubx}">
            <option value="${item.region}">${item.region}</option>
         </c:forEach> 
       </select>
     </p>
     <p>
     <label for="Federation">Federation :</label>
       <select name="Federation" id="Federation">
         <c:forEach var="item" items="${clubv}">
            <option value="${item.nomFederation}">${item.nomFederation}</option>
         </c:forEach> 
       </select>
     </p>
     <input type="submit" value="Envoyer">
  </form>
   
     <a href="./ServDirection" class="btn btn-outline-primary" style="border-radius: 20px; border-width: 2px; border-color: #fff; background-color: #ccc; color: #666;">Retour à la page d'accueil</a>
      
       <script>
    $(document).ready(function() {
      $('#Region').select2();
    });
    
    $(document).ready(function() {
        $('#Federation').select2();
      });
    
    
  </script>
     
</body>
</html>