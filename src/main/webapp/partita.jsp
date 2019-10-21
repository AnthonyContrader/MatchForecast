<%@ page import="it.contrader.dto.PartitaDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Partita Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Partita Manager</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<%@ include file="./functionbar/menu.jsp" %>

	<div class="main">
		<%
			List<PartitaDTO> list = (List<PartitaDTO>) request.getSession().getAttribute("list");
		%>

		<br>
		<table>
			<tr>
				<th>codiceForecast</th>
				<th>Squadra1</th>
				<th>squadra2</th>
				<th>Data</th>
		        <th>Orario</th>
		        <th>GoalCasa</th>
		        <th>GoalTrasferta</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (PartitaDTO u : list) {
			%>
			<tr>
				<td><a href="/partita/read?idPartita=<%=u.getIdPartita()%>">  <%=u.getCodiceForecast()%>
				</a></td>
				
				<td><%=u.getSquadra1()%></td>
				<td><%=u.getSquadra2()%></td>
                <td><%=u.getData()%></td>
                <td><%=u.getOrario()%></td>
                <td><%=u.getGoalCasa()%></td>	
                <td><%=u.getGoalTrasferta()%></td>	
				<td><a
					href="/insertPartita.jsp">Insert</a></td>
				
				<td><a href="/partita/preupdate?idPartita=<%=u.getIdPartita()%>">Edit</a></td>


				 <td><a href="/partita/delete?idPartita=<%=u.getIdPartita()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		
		
		

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>
		