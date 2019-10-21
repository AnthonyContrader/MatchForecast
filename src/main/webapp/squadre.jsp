<%@ page import="it.contrader.dto.SquadraDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Squadra Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Squadra Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<%@ include file="./functionbar/menu.jsp"%>
	<div class="main">
		<%
			List<SquadraDTO> list = (List<SquadraDTO>) request.getSession().getAttribute("list");
		%>

		<br>

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
				<th></th>
				<th></th>
			</tr>
			<%
				for (SquadraDTO f : list) {
			%>
			<tr>
				<td><a href="/squadre/read?idSquadra=<%=f.getIdSquadra()%>"><%=f.getNomeSquadra()%>
				</a></td>
				<td><%=f.getNumGiocatori()%></td>
				<td><%=f.getRating()%></td>
				<td><%=f.getVittorieCasa()%></td>
				<td><%=f.getVittorieEsterne()%></td>
				<td><%=f.getSconfitteCasa()%></td>
				<td><%=f.getSconfitteEsterne()%></td>
				<td><%=f.getPareggiCasa()%></td>
				<td><%=f.getPareggiEsterne()%></td>
				<td><a
					href="/insertSquadra.jsp">Insert</a></td>

				<td><a
					href="/squadre/preupdate?idSquadra=<%=f.getIdSquadra()%>">Edit</a></td>


				<td><a href="/squadre/delete?idSquadra=<%=f.getIdSquadra()%>">Delete</a></td>

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