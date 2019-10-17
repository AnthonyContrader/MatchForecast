<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<%@ include file="./functionbar/menu.jsp" %>

	<br>

	<div class="main">
		<%
			UserDTO u = (UserDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Username</th>
				<th>Password</th>
				<th>Usertype</th>
		        <th>Weekly Summary</th>
		        <th>Monthly Summary</th>
		        <th>Annual Summary</th>
		        <th>Wallet</th>
			</tr>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getUsername()%></td>
				<td><%=u.getPassword()%></td>
				<td><%=u.getUsertype()%></td>
                <td><%=u.getWSummary()%></td>
                <td><%=u.getMSummary()%></td>
                <td><%=u.getASummary()%></td>
                <td><%=u.getWallet()%></td>			
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>