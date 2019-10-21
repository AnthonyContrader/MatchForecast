<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.SquadraDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Squadra Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Squadra</title>


</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<%@ include file="./functionbar/menu.jsp"%>
	<div class="main">
		<%
			SquadraDTO f = (SquadraDTO) request.getSession().getAttribute("dto");
		%>

		<form id="floatleft" action="/squadre/update" method="post">
			<div>
				<input type="hidden" name="idSquadra" value=<%=f.getIdSquadra()%>>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="">nomeSquadra</label>
				</div>
				<div class="col-75">
					<input type="text" id="nSqua" name="nomeSquadra"
						value=<%=f.getNomeSquadra()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="numGio">numGiocatori</label>
				</div>
				<div class="col-75">
					<input type="text" id="numGio" name="numGiocatori"
						value=<%=f.getNumGiocatori()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="rat">rating</label>
				</div>
				<div class="col-75">
					<input type="text" id="rat" name="rating" value=<%=f.getRating()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="vitCas">vittorieCasa</label>
				</div>
				<div class="col-75">
					<input type="text" id="vitCas" name="vittorieCasa"
						value=<%=f.getVittorieCasa()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="vitEs">vittorieEsterne</label>
				</div>
				<div class="col-75">
					<input type="text" id="vitEs" name="vittorieEsterne"
						value=<%=f.getVittorieEsterne()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="scoC">sconfitteCasa</label>
				</div>
				<div class="col-75">
					<input type="text" id="scoC" name="sconfitteCasa"
						value=<%=f.getSconfitteCasa()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="scoE">sconfitteEsterne</label>
				</div>
				<div class="col-75">
					<input type="text" id="scoE" name="sconfitteEsterne"
						value=<%=f.getSconfitteEsterne()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="parCa">pareggiCasa</label>
				</div>
				<div class="col-75">
					<input type="text" id="parCa" name="pareggiCasa"
						value=<%=f.getPareggiCasa()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="parEs">pareggiEsterne</label>
				</div>
				<div class="col-75">
					<input type="text" id="parEs" name="pareggiEsterne"
						value=<%=f.getPareggiEsterne()%>>
				</div>
			</div>
			<button type="submit">Edit</button>
			<button type="button"
				onclick="window.location.href = '/squadre/getall';">Back</button>

		</form>



	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>