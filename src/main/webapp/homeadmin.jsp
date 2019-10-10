<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"
    import="it.contrader.dto.PartitaDTO"
    import="it.contrader.dto.SquadraDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="PartitaServlet?mode=partitalist">Partite</a>
  <a href="SquadraServlet?mode=squadralist">Squadre</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
<h1>Welcome ${user.getUsername()}</h1>

Previsione Di match 



</div>


<%@ include file="css/footer.jsp" %>

</body>
</html>