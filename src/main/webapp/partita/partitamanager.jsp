<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" 
    import="it.contrader.dto.PartitaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Partita Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="PartitaServlet?mode=partitalist">Partite</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%List<PartitaDTO> list = (List<PartitaDTO>) request.getAttribute("list");%>

<br>


<table>
		<tr>
			<th>Squadra1</th>
			<th>Squadra2</th>
			<th>Data</th>
			<th>Orario</th>
			<th>GoalCasa</th>
			<th>GoalTrasferta</th>
			<th></th>
			<th></th>
		</tr>
        <%
			for (PartitaDTO p : list) {
		%>
		<tr>
			<td><a href=PartitaServlet?mode=read&id=<%=p.getId()%>>
					<%=p.getSquadra1()%>
			</a> 
			<td><%=p.getSquadra2()%></td>
			<td><%=p.getData()%></td>
			<td><%=p.getOrario()%></td>
			<td><%=p.getGoalCasa()%></td>
			<td><%=p.getGoalTrasferta()%></td>
			<td><a href=PartitaServlet?mode=read&update=true&id=<%=p.getId()%>>Edit</a>
			</td>
			<td><a href=PartitaServlet?mode=delete&id=<%=p.getId()%>>Delete</a>
			</td>

		
</tr>
		<%
			}
		%>
	</table>
<form id="floatright" action="PartitarServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="sq1">Squadra1</label>
    </div>
    <div class="col-75">
      <input type="text" id="sq1" name="squadra1" placeholder="inserisci squadra1">
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="sq2">Squadra2</label>
    </div>
    <div class="col-75">
      <input type="text" id="sq2" name="squadra2" placeholder="inserisci squadra2">
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="dt">Data</label>
    </div>
    <div class="col-75">
      <input type="text" id="dt" name="data" placeholder="inserisci data"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="or">Orario</label>
    </div>
    <div class="col-75">
      <input type="text" id="or" name="orario" placeholder="inserisci orario"> 
    </div>
  </div>
  
   
    <div class="row">
    <div class="col-25">
     <label for="gc">GoalCasa</label>
    </div>
    <div class="col-75">
      <input type="text" id="gc" name="goalcasa" placeholder="inserisci goalcasa"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="gt">GoalTrasferta</label>
    </div>
    <div class="col-75">
      <input type="text" id="gt" name="goaltrasferta" placeholder="inserisci goaltrasferta"> 
    </div>
  </div>
 
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>