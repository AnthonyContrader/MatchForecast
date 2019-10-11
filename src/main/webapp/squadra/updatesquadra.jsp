<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SquadraDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Squadra</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../functions/menuPartita.jsp" %>
<div class="main">

<%SquadraDTO u = (SquadraDTO) request.getAttribute("dto"); %>


<form id="floatleft" action="SquadraServlet?mode=update&id=<%=u.getId()%>" method="post">
<div class="row">
<div class="col-25">
<label for="squa">nomeSquadra</label>
</div>
<div class="col-75">
<input type="text" id="squa" name="nomeSquadra" value=<%=u.getNomeSquadra()%>>
</div>
</div>
<div class="row">
<div class="col-25">
<label for="numG">numGiocatori</label>
</div>
<div class="col-75">
<input type="text" id="numG" name="numGiocatori" value=<%= u.getNumGiocatori()%>>
</div>
</div>
<div class="row">
    <div class="col-25">
      <label for="rat">rating</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="rat" name="rating" value=<%= u.getRating() %>>
 			</div>
 			</div>
 <div class="row">
    <div class="col-25">
      <label for="vitC">vittorieCasa</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="vitC" name="vittorieCasa" value=<%= u.getVittorieCasa() %>>
 			</div>
 			</div>
 <div class="row">
    <div class="col-25">
      <label for="vitE">vittorieEsterne</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="vitE" name="vittorieEsterne" value=<%= u.getVittorieEsterne() %>>
 			</div>
 			</div>	
<div class="row">
    <div class="col-25">
      <label for="scoC">sconfitteCasa</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="scoC" name="sconfitteCasa" value=<%= u.getSconfitteCasa() %>>
 			</div>
 			</div> 
 <div class="row">
    <div class="col-25">
      <label for="scoE">sconfitteEsterne</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="scoE" name="sconfitteEsterne" value=<%= u.getSconfitteEsterne() %>>
 			</div>
 			</div>	
 <div class="row">
    <div class="col-25">
      <label for="parC">pareggiCasa</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="parC" name="pareggiCasa" value=<%= u.getPareggiCasa() %>>
 			</div>
 			</div>
 <div class="row">
    <div class="col-25">
      <label for="parE">pareggiEsterne</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="parE" name="pareggiEsterne" value=<%= u.getPareggiEsterne() %>>
 			</div>
 			</div>
 	<button type="submit" >Edit</button>				
</form>


</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>