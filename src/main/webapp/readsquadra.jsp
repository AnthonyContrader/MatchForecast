<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SquadraDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Squadra Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Squadra</title>
</head>
<body>
     <%@ include file="./css/header.jsp"%>
     <%@ include file="./functionbar/menu.jsp" %>

      <br>
      
      <div class="main" >
      <%
           SquadraDTO f= (SquadraDTO) request.getSession().getAttribute("dto");
      %>
      
      <table>
           <tr>
               <th>idSquadra</th>
               <th>nomeSquadra</th>
               <th>numGiocatori</th>
               <th>rating</th>
               <th>vittorieCasa</th>
               <th>vittorieEsterne</th>
               <th>sconfitteCasa</th>
               <th>sconfitteEsterne</th>
               <th>pareggiCasa</th>
               <th>pareggiEsterne</th>
           </tr>
           <tr>
             <td><%=f.getIdSquadra()%></td>
             <td><%=f.getNomeSquadra()%></td>
             <td><%=f.getNumGiocatori()%></td>
             <td><%=f.getRating()%></td>
             <td><%=f.getVittorieCasa() %></td>
             <td><%=f.getVittorieEsterne()%></td>
             <td><%=f.getSconfitteCasa()%></td>
             <td><%=f.getSconfitteEsterne() %></td>
             <td><%=f.getPareggiCasa()%></td>
             <td><%=f.getPareggiEsterne()%></td>
           </tr>
       </table>
               
       <br> <br> <br> <br> <br> <br> <br>
	   <br> <br> <br> <br> <br> <br> <br>

	 </div>
	 <%@ include file="./css/footer.jsp"%>
</body>
</html>