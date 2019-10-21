<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "it.contrader.dto.ForecastDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Forecast Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Forecast</title>


</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/forecast/getall">Forecast</a>
  <a href="/forecast/logout" id="logout">Logout</a>
  <br>
  </div>
  <div class="main">
          <%ForecastDTO f = (ForecastDTO) request.getSession().getAttribute("dto");%>
          
   <form id="floatleft" action="/forecast/update" method="post">
   <div><input type="hidden" name="codiceForecast" value =<%=f.getCodiceForecast() %>></div>
   <div class="row">
   <div class="col-25">
      <label for="id">ID</label>
    </div>
    <div class="col-75">
      <input type="text" id="id" name="id" value=<%=f.getId()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="inv">Investimento</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="inv" name="investimento" value=<%=f.getInvestimento()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="guad">Guadagno</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="guad" name="guadagno" value=<%=f.getGuadagno()%>> 
    </div>
  </div>
  <div class="row">
				<div class="col-25">
					<label for="pris">pRischio</label>
				</div>
				<div class="col-75">
					<input type="text" id="pris" name="pRischio"
						value=<%=f.getPRischio() %>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="inv">Wallet</label>
				</div>
				<div class="col-75">
					<input type="text" id="wall" name="wallet"
						value=<%=f.getWallet() %>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="dura">Durata</label>
				</div>
				<div class="col-75">
					<input type="text" id="dura" name="durata"
						value=<%=f.getDurata() %>>
				</div>
			</div>
			<button type="submit" >Edit</button>
			<button type="button" onclick="window.location.href = '/forecast/getall';">Back</button>
</form>



  </div>
  <br>
  <%@ include file="./css/footer.jsp" %>	
</body>
</html>