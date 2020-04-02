<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv = "content-type" content ="text/html; charset= UTF-8">
		<title>ログイン</title>
		<link rel ="stylesheet" href = "/styles.css" type ="text/css">
	</head>
	<body onload = "fieldChanged();">
		<p>${loginBean }</p>
		<h1>ログイン</h1>
		<hr>
		<div align = "center">
			<table class = "table">
				<form action = "LoginServlet" method ="post">
					<input type = "hidden" name = "action" value = "login_action" class="input">
					<tr>
						<th class = "login_field">
						ユーザID
						</th>
						<td class = "login_field">
							<input type = "text" name = "username" value="" id = "user_id"
							onkeyup = "fieldChanged();"
							onchange = "fieldChanged();" class="input">
						</td>
					</tr>
					<tr>
						<th class = "login_field">
						パスワード
						</th>
						<td class = "login_field">
							<input type = "password" name = "password" value = "" id = "password"
							onkeyup = "fieldChanged();"
							onchange = "fieldChanged();">
						</td>
					</tr>
					<tr>
						<td colspan = "2" class = "login_button">
							<input type = "submit" value = "ログイン" id = "login">
						</td>
					</tr>
				</form>
			</table>
		</div>
	<script src = "/main.js" type = "text/javascript"></script>
	</body>
</html>