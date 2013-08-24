<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="websakila.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actores</title>
</head>
<body>
<jsp:useBean id="BusquedaBEAN" class="websakila.BusquedaBEAN" scope="request"/>
<%
out.print("<table>");
for(int i=0;i<BusquedaBEAN.getFirstName().size();i++){
	out.print("<tr><td>"+BusquedaBEAN.getFirstName().get(i)+"</td><td>"+BusquedaBEAN.getLastName().get(i)+"</td></tr>");
}
%>
<br><a href="acceso.jsp">Acceso</a>
</body>
</html>