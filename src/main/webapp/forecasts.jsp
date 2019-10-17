<%@ page import= "it.contrader.dto.ForecastDTO" import= "java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Forecast Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Forecast Manager</title>

</head>
<body>
<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
		href="/forecast/getall">Forecast</a> <a href="/forecast/logout" id="logout">Logout</a>
	</div>
<div class="main">
           <%
                      List<ForecastDTO> list = (List<ForecastDTO>) request.getSession().getAttribute("list");
           %>
           
           <br>
           
           <table>
           <tr>
				<th>ID</th>
				<th>Investimento</th>
				<th>Guadagno</th>
		        <th>pRischio</th>
		        <th>Wallet</th>
		        <th>Durata</th>
		        <th></th>
				<th></th>
		  </tr>
           <%
				for (ForecastDTO f : list) {
			%>
			<tr>
			   <td><a href="/forecast/read?codiceForecast=<%=f.getCodiceForecast()%>"></a></td>
			  <td><%=f.getId()%></td>
              <td><%=f.getInvestimento() %></td>
              <td><%=f.getGuadagno() %></td>
              <td><%=f.getPRischio()  %></td>
              <td><%=f.getWallet()  %></td>
              <td><%=f.getDurata()  %></td>
              
              <td><a href="/forecast/preupdate?codiceForecast=<%=f.getCodiceForecast()%>">Edit</a></td>
              
              
              <td><a href="/forecast/delete?codiceForecast=<%=f.getCodiceForecast()%>">Delete</a></td>
             
             </tr>
             <%
             }
             %>
           </table>
           
           
           <form id="floatright" action="/forecast/insert" method="post">
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
		</form>
		
           </div>
           <br>
           <%@ include file="./css/footer.jsp"%>
</body>
</html>