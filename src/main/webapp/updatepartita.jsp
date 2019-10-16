<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PartitaDTO"%>
    <!DOCTYPE html>�
    <html>
    <head>
    <meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Partita</title>
    
   </head>
    
   <body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/partita/getall">Partite</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main"> 

<%PartitaDTO u =(PartitaDTO) request.getSession().getAttribute("dto"); %>

  <form id="floatleft" action="/partite/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="cf">CodiceForecast</label>
    </div>
    <div class="col-75">
      <input type="text" id="cf" name="codiceForecast" value=<%=u.getCodiceForecast()%>>
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="sq1">Squadra1</label>
    </div>
    <div class="col-75">
      <input type="text" id="sq1" name="squadra1" value=<%=u.getSquadra1()%>>
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="sq2">Squadra2</label>
    </div>
    <div class="col-75">
      <input type="text" id="sq2" name="squadra2" value=<%=u.getSquadra2()%>>
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="dt">Data</label>
    </div>
    <div class="col-75">
      <input type="text" id="dt" name="data" value=<%=u.getData()%>>
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="or">Orario</label>
    </div>
    <div class="col-75">
      <input type="text" id="or" name="orario" value=<%=u.getOrario()%>>
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="gc">GoalCasa</label>
    </div>
    <div class="col-75">
      <input type="text" id="gc" name="goalCasa" value=<%=u.getGoalCasa()%>>
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="gt">GoalTrasferta</label>
    </div>
    <div class="col-75">
      <input type="text" id="gt" name="goalTrasferta" value=<%=u.getGoalTrasferta()%>>
    </div>
  </div>
     <button type="submit" >Edit</button>
</form>
    
    
    
    
    
    
    </div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    </html>