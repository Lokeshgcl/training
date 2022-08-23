<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarining</title>
<style>
table, th, td {
	border: 2px solid black;
	border-collapse: collapse;
	border-color: #faad89;
}

.tbody {
	max-width: max-content;
	margin: auto;
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
	<h1>Delete Tarinings</h1>
	<form action="training" method="post">
		<input type="hidden" name="actionType" value="DeleteTraining" />
		<table cellspacing="2" cellpadding="2">

			<tr>
				<th>select</th>
				<th>Training Name</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Training Mode</th>
				<th>Businisess Unit</th>
				<th>Contact Person email Id</th>
			</tr>
			<%
			if (request.getAttribute("TrainingList") != null) 
			{
				Iterator<TrainingModel> iterator = trainingList.iterator(); 

				while (iterator.hasNext()) 
				{
					TrainingModel training = iterator.next(); 
			%>
			<tr>
				<td><input type="checkbox" name="trainingCheckBox"
					value=<%=training.getTrainingID()%>></td>
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
		<br>
		<input type="submit" value="Submit">
	</form>

</body>
</html>