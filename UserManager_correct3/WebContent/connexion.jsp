<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
<link rel="stylesheet" type="text/css" href="css.css" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
</head>
<body>
<fieldset>
<form action="Connexion" method = "post">
<label for ="login">Entrez votre adresse mail</label>
<input type="text" name="mail"/><br>
<label for ="login">Entrez votre mot de passe</label>
<input type="password" name="pwd"/><br>
<input type="submit" value="Se connecter"/>
</form>
</fieldset>
<c:if test="${ actionMessage eq 'Connexion réussie' }">
<br>
<fieldset>
<p>Bienvenue : ${newUser.nom}</p>
</fieldset>
</c:if>
</body>
</html>