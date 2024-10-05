<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>
    #my-div {
      width: 500px;  /* Définir la largeur */
      height: 500px; /* Définir la hauteur */
      background-color: white; /* Définir la couleur de fond pour visualiser le div */
      position: absolute;
      top: 50%;
      left: 50%;
     
    }
  </style>
      <link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
      <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
</head>
<body>

<c:out value="${infosclub.l_2019 }"/>
<div id="my-div">
 <canvas id="myChart"></canvas>

	<script>
		var ctx = document.getElementById('myChart').getContext('2d');
		var data = {
			labels: ['Homme','Femme'],
			datasets: [{
				label: 'Nombre de licenciés par fedération en fonction du critère du genre',
				data: [${infosclub.lh2019 }, ${infosclub.lf2019 }],
				backgroundColor: [
					'rgba(255, 99, 132, 0.2)',
					'rgba(54, 162, 235, 0.2)',
					'rgba(255, 206, 86, 0.2)',
					'rgba(75, 192, 192, 0.2)',
					'rgba(153, 102, 255, 0.2)',
					'rgba(255, 159, 64, 0.2)'
				],
				borderColor: [
					'rgba(255, 99, 132, 1)',
					'rgba(54, 162, 235, 1)',
					'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)',
					'rgba(153, 102, 255, 1)',
					'rgba(255, 159, 64, 1)'
				],
				borderWidth: 1
			}]
		};
		var options = {
			responsive: true,
			title: {
				display: true,
				text: 'Ventes par mois'
			}
		};

		var myChart = new Chart(ctx, {
			type: 'pie',
			data: data,
			options: options
		});
	</script>
</div>

<form method="post" action="./ServVisua">
       <p>
      <label for="Commune">commune :</label>
       <select name="Commune" id="Commune">
         <c:forEach var="item" items="${clubos}">
            <option value="${item.nomCommune}">${item.nomCommune}</option>
         </c:forEach> 
       </select>
      </p>
     <p>
      <label for="Federation">Federation :</label>
       <select name="Nomfederation" id="Nomfederation">
         <c:forEach var="item" items="${clubv}">
            <option value="${item.nomFederation}">${item.nomFederation}</option>
         </c:forEach> 
       </select>
      </p>
 <input type="submit" value="Envoyer">
</form>

 <script>
    $(document).ready(function() {
      $('#Commune').select2();
    });
    
    $(document).ready(function() {
        $('#Nomfederation').select2();
      });
  </script>
  
   <a href="./ServDirection" class="btn btn-outline-primary" style="border-radius: 20px; border-width: 2px; border-color: #fff; background-color: #ccc; color: #666;">Retour à la page d'accueil</a>
        
</body>


</html>