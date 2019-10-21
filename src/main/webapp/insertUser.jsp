<%@ page import="it.contrader.dto.UserDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>User Insert</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<%@ include file="./functionbar/menu.jsp"%>


<form id="floatleft" action="/user/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Username</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="username"
						placeholder="inserisci username">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Password</label>
				</div>
				<div class="col-75">
					<input type="text" id="pass" name="password"
						placeholder="inserisci password">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Usertype</label>
				</div>
				<div class="col-75">
					<select id="type" name="usertype">
						<option value="ADMIN">ADMIN</option>
						<option value="USER">USER</option>

					</select>
				</div>
			</div>
			 <div class="row">
				<div class="col-25">
					<label for="ws">Weekly Summary</label>
				</div>
				<div class="col-75">
					<input type="text" id="ws" name="wSummary"
						placeholder="inserisci weekly summary">
				</div>
			</div>
			 <div class="row">
				<div class="col-25">
					<label for="ms">Monthly Summary</label>
				</div>
				<div class="col-75">
					<input type="text" id="ms" name="mSummary"
						placeholder="inserisci monthly summary">
				</div>
			</div>
			 <div class="row">
				<div class="col-25">
					<label for="as">Annual Summary</label>
				</div>
				<div class="col-75">
					<input type="text" id="as" name="aSummary"
						placeholder="inserisci annual summary">
				</div>
			</div>
			
			 <div class="row">
				<div class="col-25">
					<label for="wall">Wallet</label>
				</div>
				<div class="col-75">
					<input type="text" id="wall" name="wallet"
						placeholder="inserisci wallet">
				</div>
			</div>
			<button type="submit">Insert</button>
		<button type="button" onclick="window.location.href = '/user/getall';">Back</button>

		</form>
		
		
		</body>
	</html>