<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PartitaDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Partita Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Partita</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<%@ include file="./functionbar/menu.jsp" %>

	<br>

	<div class="main">
		<%
			PartitaDTO u = (PartitaDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>IdPartita</th>
				<th>CodiceForecast</th>
				<th>Squadra1</th>
				<th>squadra2</th>
		        <th>Data</th>
		        <th>Orario</th>
		        <th>GoalCasa</th>
		        <th>GoalTrasferta</th>
			</tr>
			<tr>
				<td><%=u.getIdPartita()%></td>
				<td><%=u.getCodiceForecast()%></td>
				<td><%=u.getSquadra1()%></td>
				<td><%=u.getSquadra2()%></td>
                <td><%=u.getData()%></td>
                <td><%=u.getOrario()%></td>
                <td><%=u.getGoalCasa()%></td>
                <td><%=u.getGoalTrasferta()%></td>			
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>