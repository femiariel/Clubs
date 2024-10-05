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


<style>
     #maCarte{
     height: 600px;
     }
     </style>
      <link rel="shortcut icon" type="image/png" href="images/favicon.png"/>    
      <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-NxQ3oKRzMnM9JahNl1/02jWSL/Wh+qmF0q3JwLj+LPD2yL9l9vUbJWlsdk+ZaV7Z" crossorigin="anonymous">
  <!-- Liens vers les fichiers JS de Bootstrap -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-Q9XHmOm8jKgJmewd7f+R/02tj8WHzrq1MxRxMn/9Kv+64e3qB5Ch5iqZj5otvJz" crossorigin="anonymous"></script>
</head>
<body >
   <div id="maCarte"></div>
    
    <!-- Fichier Javascript -->
      <script src="https://unpkg.com/leaflet@1.9.3/dist/leaflet.js"
     integrity="sha256-WBkoXOwTeyKclOHuWtc+i2uENFpDZ9YPdf5Hf+D7ewM="
     crossorigin=""></script>    
     <script>
     
     
  // On initialise la  carte
     var centre = [${club.latitude }, ${club.longitude }]
     var carte = L.map('maCarte').setView(centre, 6);
  
  // On charge les tuiles
     var OpenStreetMap_France = L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
     	maxZoom: 20,
     	attribution: '&copy; OpenStreetMap France | &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
     
     }).addTo(carte);
  
     <c:forEach var="item" items="${clubs}">
     
     
     var distance = carte.distance(centre, [${item.latitude}, ${item.longitude}]);
     console.log( distance+ "le rayon est" + "${item.rayon}");
     if (distance <= ${item.rayon}) {
         
         var marqueur = L.marker([${item.latitude}, ${item.longitude}]).addTo(carte);
         marqueur.bindPopup(`<b>${item.nomCommune}</b><br>${item.nomFederation}`);
         marqueur.on('click', function(e) {
           this.closePopup();
           this.openPopup();
         });
       
         
     }
    
     </c:forEach>

     
     
                       
    
     
       
       
     </script>
       
   
      <form method="post" action="./ServRayon" class="row align-items-center">
 <div class="col-md-3 my-2">
  <label for="Region" class="form-label">Region:</label>
  <select name="Region" id="Region" class="form-select">
    <c:forEach var="item" items="${clubx}">
      <option value="${item.region}">${item.region}</option>
    </c:forEach> 
  </select>
</div>

<div class="col-md-3 my-2">
  <label for="Commune" class="form-label">commune :</label>
  <select name="Commune" id="Commune" class="form-select">
    <c:forEach var="item" items="${clubos}">
      <option value="${item.nomCommune}">${item.nomCommune}</option>
    </c:forEach> 
  </select>
</div>

<div class="col-md-3 my-2">
  <label for="Rayon" class="form-label">Le rayon à renseigner est en mètres:</label>
  <input type="number" id="Rayon" name="Rayon" class="form-control">
</div>

<div class="col-md-3 my-2">
  <label for="Federation" class="form-label">Federation :</label>
  <select name="Federation" id="Federation" class="form-select">
    <c:forEach var="item" items="${clubv}">
      <option value="${item.nomFederation}">${item.nomFederation}</option>
    </c:forEach> 
  </select>
</div>
 
 <div class="col-md-12 mt-3">
  <input type="submit" value="Envoyer" class="btn btn-primary" style="background-color: #f2f2f2; border-color: #fff; border-width: 2px; border-radius: 5px; color: #000;">
</div>
 </form>
      
    
     
      
 <a href="./ServDirection" class="btn btn-outline-primary" style="border-radius: 20px; border-width: 2px; border-color: #fff; background-color: #ccc; color: #666;">Retour à la page d'accueil</a>
 
  
  
    
     <script>
    $(document).ready(function() {
      $('#Region').select2();
    });
    
    $(document).ready(function() {
        $('#Commune').select2();
      });
    
    $(document).ready(function() {
        $('#Federation').select2();
      });
    
    
  </script>
</body>
</html>
