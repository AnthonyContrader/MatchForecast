<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.SquadraDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Squadra Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<%@ include file="../functions/menuSquadra.jsp" %>
<div class="main">
<%
  List<SquadraDTO> list = (List<SquadraDTO>) request.getAttribute("list");
 %>
 
 <br>
 
 <table>
 <tr>
 <th>nomeSquadra</th>
 <th>numGiocatori</th>
 <th>rating</th>
 <th>vittorieCasa</th>
 <th>vittorieEsterne</th>
 <th>sconfitteCasa</th>
 <th>sconfitteEsterne</th>
 <th>pareggiCasa</th>
 <th>pareggiESterne</th>
 <th></th>
 <th></th>
 </tr>
 <%
 for (SquadraDTO u : list) {
%>	
 <tr>
 <td><a href="/squadra/read?id=<%=u.getNomeSquadra()%>"> <%=u.getNumGiocatori()%>
 </a></td>
 <td><%=u.getRating() %></td>
  <td><%=u.getVittorieCasa() %></td>
 <td><%=u.getVittorieEsterne() %></td>
  <td><%=u.getSconfitteCasa() %></td>
 <td><%=u.getSconfitteEsterne() %></td>
  <td><%=u.getPareggiCasa() %></td>
 <td><%=u.getPareggiEsterne() %></td>
 <td><a href="/squadra/preupdate?id=<%=u.getNomeSquadra()%>">Edit</a>
 </td>
 <td><a href="/squadra/delete?id=<%=u.getNomeSquadra()%>">Delete</a>
 </td>
 
 </tr>
 <% 
 } 
 %>
 </table>
 
 
 <form id="floatright" action="/user/insert" method="post">
 <div class="row">
 <div class="col-25">
 <label for="squa">nomeSquadra</label>
 </div>
 <div class="col-75">
 <input type="text" id="squa" name="nomeSquadra"  placeholder="inserisci nomeSquadra">
 </div>
 </div>
 <div class="row">
 <div class="col-25">
 <label for="numG">numGIocatori</label>
 </div>
 <div class="col-75">
 <input type="text" id="numG" name="numGiocatori"  placeholder="inserisci numGiocatori">
 </div>
 </div>
 <div class="row">
 <div class="col-25">
 <label for="rat">rating</label>
 </div>
 <div class="col-75">
 <input type="text" id="rat" name="rating"  placeholder="inserisci rating">
 </div>
 </div>
 <div class="row">
 <div class="col-25">
 <label for="vitC">vittorieCasa</label>
 </div>
 <div class="col-75">
 <input type="text" id="vitC" name="vittorieCasa"  placeholder="inserisci vittorieCasa">
 </div>
 </div>
 <div class="row">
 <div class="col-25">
 <label for="vitE">vittorieEsterne</label>
 </div>
 <div class="col-75">
 <input type="text" id="vitE" name="vittorieEsterne"  placeholder="inserisci vittorieEsterne">
 </div>
 </div>
 <div class="row">
 <div class="col-25">
 <label for="scoC">sconfitteCasa</label>
 </div>
 <div class="col-75">
 <input type="text" id="scoC" name="sconfitteCasa"  placeholder="inserisci sconfitteCasa">
 </div>
 </div>
 <div class="row">
 <div class="col-25">
 <label for="scoE">sconfitteEsterne</label>
 </div>
 <div class="col-75">
 <input type="text" id="scoE" name="sconfitteEsterne"  placeholder="inserisci sconfitteEsterne">
 </div>
 </div>
 <div class="row">
 <div class="col-25">
 <label for="parC">pareggiCasa</label>
 </div>
 <div class="col-75">
 <input type="text" id="parC" name="pareggiCasa"  placeholder="inserisci pareggiCasa">
 </div>
 </div>
 <div class="row">
 <div class="col-25">
 <label for="parE">pareggiEsterne</label>
 </div>
 <div class="col-75">
 <input type="text" id="parE" name="pareggiEsterne"  placeholder="inserisci pareggiEsterne">
 </div>
 </div>
 
 <button type="submit" >Insert</button>

 </form>
 
</div>
<br>
<%@ include file="../css/footer.jsp" %>   
</body>
</html>