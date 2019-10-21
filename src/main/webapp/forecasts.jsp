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

	<%@ include file="./functionbar/menu.jsp" %>
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
			   <td><a href="/forecast/read?codiceForecast=<%=f.getCodiceForecast()%>">
			  <%=f.getId()%></a></td>
              <td><%=f.getInvestimento() %></td>
              <td><%=f.getGuadagno() %></td>
              <td><%=f.getPRischio()  %></td>
              <td><%=f.getWallet()  %></td>
              <td><%=f.getDurata()  %></td>
              <td><a href="/insertForecast.jsp">Insert</a></td>
              <td><a href="/forecast/preupdate?codiceForecast=<%=f.getCodiceForecast()%>">Edit</a></td>
              
              
              <td><a href="/forecast/delete?codiceForecast=<%=f.getCodiceForecast()%>">Delete</a></td>
             
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