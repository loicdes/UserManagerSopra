<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="java.util.HashMap" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<link rel="stylesheet" type="text/css" href="css.css" />
<body>
<c:import url="form.jsp" />
<br />
<c:if test="${ actionMessage eq 'Inscription r�ussie' }">
<c:import url="card.jsp" />
</c:if>
</body>
</html>