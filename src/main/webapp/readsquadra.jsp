<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SquadraDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Squadra</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="./functionbar/menu.jsp" %>


<div class="main">
<%SquadraDTO u = (SquadraDTO) request.getAttribute("dto"); %>
<table>
<tr>
<th>nomeSquadra</th>
<th>numGiocatori</th>
<th>rating</th>
<th>vittorieCasa</th>
<th>vittorieEsterne</th>
<th>sconfitteCasa</th>
<th>sconfitteEsterne</th>
<th>pareggiCasa</th>
<th>pareggiEsterne</th>
</tr>
<tr>

<td><%=u.getNomeSquadra() %></td>
<td><%=u.getNumGiocatori()%></td>
<td><%=u.getRating() %></td>
<td><%=u.getVittorieCasa() %></td>
<td><%=u.getVittorieEsterne() %></td>
<td><%=u.getSconfitteCasa() %></td>
<td><%=u.getSconfitteEsterne() %></td>
<td><%=u.getPareggiCasa() %></td>
<td><%=u.getPareggiEsterne() %></td>
</tr>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>

<%@ include file="../css/footer.jsp" %>

</body>
</html>