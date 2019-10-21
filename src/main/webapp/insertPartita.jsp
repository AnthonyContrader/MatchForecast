<%@ page import="it.contrader.dto.PartitaDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Partita Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Parita Insert</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<%@ include file="./functionbar/menu.jsp"%>


<form id="floatleft" action="/partita/insert" method="post">
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
					<input type="date" id="dt" name="data"
						placeholder="DD/MM/YYYY">
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
								<button type="button" onclick="window.location.href = '/partita/getall';">Back</button>
			
		</form>
		
		
		</body>
	</html>