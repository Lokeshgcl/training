<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training</title>
<script type="text/javascript">

function validateLogin(){
	if (!document.loginForm.username.value) {
		document.getElementsByClassName("errorMessage")[0].innerText = "username cannot be empty!"
		return false;
	}else if(!document.loginForm.password.value) {
		document.getElementsByClassName("errorMessage")[0].innerText = "password cannot be empty!"
			return false;
		}
	return true;
}
</script>
<style type="text/css">
.errorMessage {
	color: red;
}

.tbody {
	max-width: max-content;
	margin: auto;
}

</style>
</head>
<body class="tbody">
	<h1>Login</h1>
	<h3 class="errorMessage"></h3>
	<form name="loginForm" action="login" method="post" onsubmit="return validateLogin()">
		<table style="with: 50%">
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>