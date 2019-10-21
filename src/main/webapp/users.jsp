<%@ page import="it.contrader.dto.UserDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<%@ include file="./functionbar/menu.jsp" %>

	<div class="main">
		<%
			List<UserDTO> list = (List<UserDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Usertype</th>
				<th>Weekly Summary</th>
		        <th>Monthly Summary</th>
		        <th>Annual Summary</th>
		        <th>Wallet</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (UserDTO u : list) {
			%>
			<tr>
				<td><a href="/user/read?id=<%=u.getId()%>"> <%=u.getUsername()%>
				</a></td>
				<td><%=u.getPassword()%></td>
				<td><%=u.getUsertype()%></td>
				<td><%=u.getWSummary()%></td>
                <td><%=u.getMSummary()%></td>
                <td><%=u.getASummary()%></td>
                <td><%=u.getWallet()%></td>		
				<td><a href="/insertUser.jsp">Insert</a></td>
				
				<td><a href="/user/preupdate?id=<%=u.getId()%>">Edit</a></td>


				<td><a href="/user/delete?id=<%=u.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>