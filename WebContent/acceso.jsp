<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acceso</title>
</head>
<body>
<table>
<jsp:useBean id="DatosBEAN" class="websakila.DatosBEAN" scope="request"/>
<tr>
<td>Bienvenido <jsp:getProperty property="nombre" name="DatosBEAN"/></td><td><a href="index.html">Logout</a></td>
<form action="Busqueda" method="post">
<tr>
<td>Buscar </td>
<td><input type="text" name="buscar"></td>
</tr>
<tr>
<td><input type="radio" name="opciones" value="Actores" checked>Actores</td>
</tr>
<tr>
<td><input type="radio" name="opciones" value="Peliculas">Películas</td>
</tr>
<td><input type="submit" value="Enviar"></td>
</tr>
</table>
</form>
</body>
</html>