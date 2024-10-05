<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>






<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.104.2">
    <title>page d'inscription</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    
    <link href="style-inscription.css" rel="stylesheet">
  </head>

  <body >

    
<main class="form-signin w-100 m-auto">
  <form action="inscription_bd.php" method="post">
    <h1 class="h3 mb-3 fw-normal">Entrez vos informations</h1>
    <div class="form-floating">
      <input type="Nom" class="form-control" id="floatingInput" placeholder="Nom"  name="le_nom">
      <label for="floatingInput">Nom</label>
    </div>
    <div class="form-floating">
      <input type="Prenom" class="form-control" id="floatingInput" placeholder="Prenom"   name="le_prenom">
      <label for="floatingInput">Prenom</label>
    </div>
    <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com"  name="l_email">
      <label for="floatingInput">Email address</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password"   name="le_pass">
      <label for="floatingPassword">Password</label>
    </div>

   
    <div class="bout ">
      
    
    <button class="w-100 m-auto btn btn-lg btn-primary" onclick="return confirm('Voulez vous vraiment envoyer le formulaire ?');" type="submit"><h5 class="text-center m-auto">Enregister  </h5></button>

    </div>
 
  </form>
</main>


    
  </body>
</html>
