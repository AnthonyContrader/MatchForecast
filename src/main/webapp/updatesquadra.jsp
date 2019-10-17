<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SquadraDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Squadra Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Squadra</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/squadra/getall">Squadre</a>
  <a href="/squadra/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%SquadraDTO u = (SquadraDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/squadra/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="squadra">NumGiocatori</label>
    </div>
    <div class="col-75">
      <input type="text" id="nGio" name="NumGiocatori" value=<%=u.getNumGiocatori()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Rating</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="rat" name="rating" value=<%=u.getRating()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">VittorieCasa</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="vitCasa" name="vittorieCasa" value=<%=u.getVittorieCasa()%>> 
    </div>
  </div>
   		 
  
     <div class="row">
    <div class="col-25">
      <label for="ws">VittorieEsterne</label>
    </div>
    <div class="col-75">
      <input type="text" id="vitEst" name="vittorieEsterne" value=<%=u.getVittorieEsterne()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="ms">SconfitteCasa</label>
    </div>
    <div class="col-75">
      <input type="text" id="scoCasa" name="sconfitteCasa" value=<%=u.getSconfitteCasa()%>>
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="as">SconfitteEsterne</label>
    </div>
    <div class="col-75">
      <input type="text" id="scoEs" name="sconfitteEsterne" value=<%=u.getSconfitteEsterne()%>>
    </div>
  </div>  
     <div class="row">
    <div class="col-25">
      <label for="wall">PareggiCasa</label>
    </div>
    <div class="col-75">
      <input type="text" id="parCasa" name="pareggiCasa" value=<%=u.getPareggiCasa() %>>
    </div>
  </div> 
      <div class="row">
    <div class="col-25">
      <label for="wall">PareggiEsterne</label>
    </div>
    <div class="col-75">
      <input type="text" id="parEs" name="pareggiEsterne" value=<%=u.getPareggiEsterne() %>>
    </div>
  </div> 
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>