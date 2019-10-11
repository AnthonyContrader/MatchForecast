<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PartitaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Partita</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../functions/menuPartita.jsp" %>
<br>
<div class="main">

<%PartitaDTO p = (PartitaDTO) request.getAttribute("dto");%>


<form id="floatleft" action="PartitaServlet?mode=update&id=<%=p.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="sq1">Squadra1</label>
    </div>
    <div class="col-75">
      <input type="text" id="sq1" name="squadra1" value=<%=p.getSquadra1()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="sq2">Squadra2</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="sq2" name="squadra2" value=<%=p.getSquadra2()%>> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="dt">Data</label>
    </div>
    <div class="col-75">
      <input type="text" id="dt" name="data" value=<%=p.getData()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="or">Orario</label>
    </div>
    <div class="col-75">
      <input type="number" id="or" name="orario" value=<%=p.getOrario()%>> 
    </div>
  </div>
  
   
    <div class="row">
    <div class="col-25">
     <label for="gc">GoalCasa</label>
    </div>
    <div class="col-75">
      <input type="text" id="gc" name="golCasa" value=<%=p.getGoalCasa()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="gt">GoalTrasferta</label>
    </div>
    <div class="col-75">
      <input type="text" id="gt" name="golTrasferta" value=<%=p.getGoalTrasferta()%>> 
    </div>
  </div>
  
  
  
      <button type="submit" >Insert</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>