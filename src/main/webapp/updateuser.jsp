<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<%@ include file="./functionbar/menu.jsp"%>

	<br>
	<div class="main">

		<%
			UserDTO u = (UserDTO) request.getSession().getAttribute("dto");
		%>


		<form id="floatleft" action="/user/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Username</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="username"
						value=<%=u.getUsername()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Password</label>
				</div>
				<div class="col-75">
					<input type="text" id="pass" name="password"
						value=<%=u.getPassword()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Usertype</label>
				</div>
				<div class="col-75">
					<select id="type" name="usertype">
						<option value="ADMIN"
							<%if (u.getUsertype().toString().equals("ADMIN")) {%> selected
							<%}%>>ADMIN</option>
						<option value="USER"
							<%if (u.getUsertype().toString().equals("USER")) {%> selected
							<%}%>>USER</option>
					</select>
				</div>
				<input type="hidden" name="id" value=<%=u.getId()%>>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="ws">Weekly Summary</label>
				</div>
				<div class="col-75">
					<input type="text" id="ws" name="wSummary"
						value=<%=u.getWSummary()%>>
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="ms">Monthly Summary</label>
				</div>
				<div class="col-75">
					<input type="text" id="ms" name="mSummary"
						value=<%=u.getMSummary()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="as">Annual Summary</label>
				</div>
				<div class="col-75">
					<input type="text" id="as" name="aSummary"
						value=<%=u.getASummary()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="wall">Wallet</label>
				</div>
				<div class="col-75">
					<input type="text" id="wall" name="wallet"
						value=<%=u.getWallet()%>>
				</div>
			</div>

			<button type="submit">Edit</button>
			<button type="button"
				onclick="window.location.href = '/user/getall';">Back</button>

		</form>


	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>