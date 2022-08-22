<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tarining</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<h1>Add Tarining</h1>
	<form action="training" method="post">
		<table style="with: 50%">
			<tr>
				<td>Training Name</td>
				<td><input type="text" name="trainingName" /></td>
			</tr>
			<tr>
				<td>Start date</td>
				<td><input type="text" name="startDate" id="startDate" /></td>
			</tr>
			<tr>
				<td>End date</td>
				<td><input type="text" name="endDate" id="endDate" /></td>
			</tr>
			<tr>
				<td>Training Mode</td>
				<td><input type="text" name="trainingMode" /></td>
			</tr>
			<tr>
				<td>BusinisessUnit</td>
				<td><input type="text" name="businisessUnit" /></td>
			</tr>
			<tr>
				<td>ContactPersonId</td>
				<td><input type="text" name="contactPersonId" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
	</form>

	<script>
		$(function() {			
			$("#startDate").datepicker({dateFormat: 'yy-mm-dd'});
			$("#endDate").datepicker({dateFormat: 'yy-mm-dd'});
		});
	</script>
</body>
</html>