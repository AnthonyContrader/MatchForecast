<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="it.contrader.dto.PartitaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Partita</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../functions/menuPartita.jsp" %>
<br>

<div class="main">
<%PartitaDTO p = (PartitaDTO) request.getAttribute("dto");%>



<table>
	<tr> 
		<th>Squadra1</th>
		<th>Squadra2</th>
		<th>Data</th>
		<th>Orario</th>
		<th>GoalCasa</th>
		<th>GoalTrasferta</th>
	</tr>
	<tr>
		<td><%=p.getSquadra1()%></td>
		<td> <%=p.getSquadra2()%></td>
		<td> <%=p.getData()%></td>
        <td> <%=p.getOrario()%></td>
        <td> <%=p.getGoalCasa()%></td>
        <td> <%=p.getGoalTrasferta()%></td>	
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>




