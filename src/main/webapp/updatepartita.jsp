<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PartitaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Partita Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Partita</title>

</head>

<body>
	<%@ include file="./css/header.jsp"%>
	<%@ include file="./functionbar/menu.jsp"%>

	<br>
	<div class="main">

		<%
			PartitaDTO u = (PartitaDTO) request.getSession().getAttribute("dto");
		%>

		<form id="floatleft" action="/partita/update" method="post">
			<div>
				<input type="hidden" name="idPartita" value=<%=u.getIdPartita()%>>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="cf">codiceForecast</label>
				</div>
				<div class="col-75">
					<input type="text" id="cf" name="codiceForecast"
						value=<%=u.getCodiceForecast()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="sq1">Squadra1</label>
				</div>
				<div class="col-75">
					<input type="text" id="sq1" name="squadra1"
						value=<%=u.getSquadra1()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="sq2">squadra2</label>
				</div>
				<div class="col-75">
					<input type="text" id="sq2" name="squadra2"
						value=<%=u.getSquadra2()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="dt">Data</label>
				</div>
				<div class="col-75">
					<input type="text" id="dt" name="data" value=<%=u.getData()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="or">Orario</label>
				</div>
				<div class="col-75">
					<input type="text" id="or" name="orario" value=<%=u.getOrario()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="gc">GoalCasa</label>
				</div>
				<div class="col-75">
					<input type="text" id="gc" name="goalCasa"
						value=<%=u.getGoalCasa()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="gt">GoalTrasferta</label>
				</div>
				<div class="col-75">
					<input type="text" id="gt" name="goalTrasferta"
						value=<%=u.getGoalTrasferta()%>>
				</div>
			</div>
			<button type="submit">Edit</button>
		    <button href=/partita/getall>Back</button>
		
		</form>






	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>

















</html>