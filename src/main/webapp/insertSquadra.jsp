<%@ page import="it.contrader.dto.SquadraDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Squadra Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Squadra Insert</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<%@ include file="./functionbar/menu.jsp"%>
	<form id="floatcenter" action="/squadre/insert" method="post">
		<div class="row">
			<div class="col-25">
				<label for="nSqua">nomeSquadra</label>
			</div>
			<div class="col-75">
				<input type="text" id="nSqua" name="nomeSquadra"
					placeholder="inserisci nomeSquadra">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="numGio">numGiocatori</label>
			</div>
			<div class="col-75">
				<input type="text" id="numGio" name="numGiocatori"
					placeholder="inserisci numGiocatori">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="rat">rating</label>
			</div>
			<div class="col-75">
				<input type="text" id="rat" name="rating"
					placeholder="inserisci il rating">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="vitCas">vittorieCasa</label>
			</div>
			<div class="col-75">
				<input type="text" id="vitCas" name="vittorieCasa"
					placeholder="inserisci vittorieCasa">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="vitEs">vittorieEsterne</label>
			</div>
			<div class="col-75">
				<input type="text" id="vitEs" name="vittorieEsterne"
					placeholder="inserisci vittorieEsterne">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="scoC">sconfitteCasa</label>
			</div>
			<div class="col-75">
				<input type="text" id="scoC" name="sconfitteCasa"
					placeholder="inserisci sconfitteCasa">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="scoE">sconfitteEsterne</label>
			</div>
			<div class="col-75">
				<input type="text" id="scoE" name="sconfitteEsterne"
					placeholder="inserisci sconfitteEsterne">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="parCa">pareggiCasa</label>
			</div>
			<div class="col-75">
				<input type="text" id="parCa" name="pareggiCasa"
					placeholder="inserisci pareggiCasa">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="parEs">pareggiEsterne</label>
			</div>
			<div class="col-75">
				<input type="text" id="parEs" name="pareggiEsterne"
					placeholder="inserisci pareggiEsterne">
			</div>
		</div>
		<button type="submit">Insert</button>
		<button type="button"
			onclick="window.location.href = '/squadre/getall';">Back</button>

	</form>



</body>
</html>