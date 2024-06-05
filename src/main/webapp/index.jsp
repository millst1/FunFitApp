<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FunFit</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body style="text-align: center;" class="bg-warning">
	<h2>FunFit Management Application</h2>
	
	<br>
	<br>
	
	<h3>Batches</h3>
	<a href="addBatch.jsp">Add Batch</a> |
	<a href="BatchController">View Batch</a> |
	<a href="BatchDeleteController">Delete Batch</a> 
	
	<br>
	<br>
	
	<h3>Participants</h3>
	<a href="addParticipants.jsp">Add Participants</a> |
	<a href="ParticipantsController">View Participants</a> |
	<a href="ParticipantsDeleteController">Delete Participant</a>
</body>
</html>