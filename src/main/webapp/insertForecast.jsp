<%@ page import="it.contrader.dto.ForecastDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Forecast Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Forecast Insert</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<%@ include file="./functionbar/menu.jsp"%>


<form id="floatleft" action="/forecast/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="id">Id</label>
				</div>
				<div class="col-75">
					<input type="text" id="id" name="id"
						placeholder="inserisci id">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="inv">Investimento</label>
				</div>
				<div class="col-75">
					<input type="text" id="inv" name="investimento"
						placeholder="inserisci l'investimento">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="guad">Guadagno</label>
				</div>
				<div class="col-75">
					<input type="text" id="guad" name="guadagno"
						placeholder="inserisci il guadagno">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pRis">pRischio</label>
				</div>
				<div class="col-75">
					<input type="text" id="pRis" name="pRischio"
						placeholder="inserisci rischio">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="wall">Wallet</label>
				</div>
				<div class="col-75">
					<input type="text" id="wall" name="wallet"
						placeholder="inserisci il portafoglio">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="dura">Durata</label>
				</div>
				<div class="col-75">
					<input type="text" id="dura" name="durata"
						placeholder="inserisci in quanto tempo">
				</div>
			</div>

			<button type="submit">Insert</button>
		<button type="button" onclick="window.location.href = '/forecast/getall';">Back</button>

		</form>
		
		
		</body>
	</html>