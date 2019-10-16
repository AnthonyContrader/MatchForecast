<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="it.contrader.dto.ForecastDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Forecast Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Forecast</title>
</head>
<body>
     <%@ include file="./css/header.jsp"%>
     <div class= "navbar"><a href= "/homeadmin.jsp">Home</a><a class= "active" 
      href = "/forecast/getall">Forecast</a><a href="/forecast/logout" id="logout"> Logout </a>
      
      </div>
      <br>
      
      <div class="main" >
      <%
           ForecastDTO f= (ForecastDTO) request.getSession().getAttribute("dto");
      %>
      
      <table>
           <tr>
               <th>CodiceForecast</th>
               <th>ID</th>
               <th>Investimento</th>
               <th>Guadagno</th>
               <th>P.Rischio</th>
               <th>Wallet</th>
               <th>Durata</th>
           </tr>
           <tr>
             <td><%=f.getCodiceForecast() %></td>
             <td><%=f.getId() %></td>
             <td><%=f.getInvestimento() %></td>
             <td><%=f.getGuadagno() %></td>
             <td><%=f.getPRischio()  %></td>
             <td><%=f.getWallet()  %></td>
             <td><%=f.getDurata()  %></td>
           </tr>
       </table>
               
       <br> <br> <br> <br> <br> <br> <br>
	   <br> <br> <br> <br> <br> <br> <br>

	 </div>
	 <%@ include file="./css/footer.jsp"%>
</body>
</html>