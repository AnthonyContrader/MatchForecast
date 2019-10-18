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
				<td><a href="/partita/preupdate?idPartita=<%=u.getIdPartita()%>">Edit</a></td>


				<td><a href="/partita/delete?idPartita=<%=u.getIdPartita()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		
		
		<form id="floatright" action="/partita/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="cf">codiceForecast</label>
				</div>
				<div class="col-75">
					<input type="text" id="cf" name="codiceForecast"
						placeholder="inserisci codice forecast">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="sq1">Squadra1</label>
				</div>
				<div class="col-75">
					<input type="text" id="sq1" name="squadra1"
						placeholder="inserisci squadra1">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="sq2">squadra2</label>
				</div>
				<div class="col-75">
					<input type="text" id="sq2" name="squadra2"
						placeholder="inserisci squadra2">
				</div>
			</div>
			 <div class="row">
				<div class="col-25">
					<label for="dt">Data</label>
				</div>
				<div class="col-75">
					<input type="text" id="dt" name="data"
						placeholder="inserisci data">
				</div>
			</div>
			 <div class="row">
				<div class="col-25">
					<label for="or">Orario</label>
				</div>
				<div class="col-75">
					<input type="text" id="or" name="orario"
						placeholder="inserisci orario">
				</div>
			</div>
			 <div class="row">
				<div class="col-25">
					<label for="gc">GoalCasa</label>
				</div>
				<div class="col-75">
					<input type="text" id="gc" name="goalCasa"
						placeholder="inserisci goal casa">
				</div>
			</div>
			
			 <div class="row">
				<div class="col-25">
					<label for="gt">GoalTrasferta</label>
				</div>
				<div class="col-75">
					<input type="text" id="gt" name="goalTrasferta"
						placeholder="inserisci goalTrasferta">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>
		