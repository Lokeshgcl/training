<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training</title>
<style type="text/css">
.tbody {
	max-width: max-content;
	margin: auto;
}

.tdiv {
	display: flex;
	justify-content: space-evenly;
}

table, th, td {
	border: 2px solid black;
	border-collapse: collapse;
	border-color: #faad89;
}
</style>
</head>
<body class="tbody">
	<%@page import="java.util.ArrayList"%>
	<%@page import="model.TrainingModel"%>
	<%@page import="java.util.Iterator"%>
	<%
	ArrayList<TrainingModel> trainingList = (ArrayList) request.getAttribute("TrainingList");
	%>
	<h1>Admin home page</h1>
	<div class="tdiv">
		<form action="admin" method="post">
			<input type="hidden" name="actionType" value="AddTraining" /> <input
				type="submit" value="Add Training" />
		</form>
		<form action="admin" method="post">
			<input type="hidden" name="actionType" value="DeleteTraining" /> <input
				type="submit" value="Delete Training" />
		</form>
	</div>
	<br>
	<table cellspacing="2" cellpadding="2">

		<tr>
			<th>Training Name</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Training Mode</th>
			<th>Businisess Unit</th>
			<th>Contact Person email Id</th>
		</tr>
		<%
		if (request.getAttribute("TrainingList") != null) {
			Iterator<TrainingModel> iterator = trainingList.iterator();

			while (iterator.hasNext()) {
				TrainingModel training = iterator.next();
		%>
		<tr>
			<td><%=training.getTrainingName()%></td>
			<td><%=training.getStartDate()%></td>
			<td><%=training.getEndDate()%></td>
			<td><%=training.getTrainingMode()%></td>
			<td><%=training.getBusinisessUnit()%></td>
			<td><%=training.getContactPersonId()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>

</body>
</html>