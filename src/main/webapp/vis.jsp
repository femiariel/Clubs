<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
      <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
</head>
<body>

        <canvas id="myCharti"></canvas>
       <script >
      // Récupérer la référence de l'élément HTML où afficher le graphique
       var ctx = document.getElementById('myCharti').getContext('2d');

       // Définir les données pour l'axe des abscisses en Java
       var labels = new Array();
       <c:forEach var="item" items="${licos}">
           labels.push("${item.commune}");
       </c:forEach>

       // Définir les données pour l'axe des ordonnées en Java
       var data = new Array();
       <c:forEach var="item" items="${licos}">
           data.push(${item.proportion});
       </c:forEach>

       // Créer le graphique
       var myCharti = new Chart(ctx, {
           type: 'bar',
           data: {
               labels: labels,
               datasets: [{
            	   label: 'Proportion de licencié(en pourcentage) par commune',
                   data: data,
                   backgroundColor: [
                       'rgba(255, 99, 132, 0.2)',
                       'rgba(54, 162, 235, 0.2)',
                       'rgba(255, 206, 86, 0.2)',
                       'rgba(75, 192, 192, 0.2)',
                       'rgba(153, 102, 255, 0.2)',
                       'rgba(255, 159, 64, 0.2)',
                       'rgba(255, 99, 132, 0.2)'
                   ],
                   borderColor: [
                       'rgba(255, 99, 132, 1)',
                       'rgba(54, 162, 235, 1)',
                       'rgba(255, 206, 86, 1)',
                       'rgba(75, 192, 192, 1)',
                       'rgba(153, 102, 255, 1)',
                       'rgba(255, 159, 64, 1)',
                       'rgba(255, 99, 132, 1)'
                   ],
                   borderWidth: 1
               }]
           },
           options: {
               scales: {
                   yAxes: [{
                       ticks: {
                    	   
                           beginAtZero: true
                       }
                   }]
           
               },
               
           }
       });

       
       
       
       
       
       
       
       
       
       </script>
       
       <form method="post" action="./ServPropCommune">
     <p>
      <label for="Region">Region:</label>
       <select name="Region" id="Region">
         <c:forEach var="item" items="${clubx}">
            <option value="${item.region}">${item.region}</option>
         </c:forEach> 
       </select>
     </p>
     <p>
    
     <input type="submit" value="Envoyer">
  </form>
      <script>
    $(document).ready(function() {
      $('#Region').select2();
    });
    
   
  </script> 
  
   <a href="./ServDirection" class="btn btn-outline-primary" style="border-radius: 20px; border-width: 2px; border-color: #fff; background-color: #ccc; color: #666;">Retour à la page d'accueil</a>
       
</body>
</html>