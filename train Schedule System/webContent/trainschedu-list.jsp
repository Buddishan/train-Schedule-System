<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Train Reservation</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #003366">
			<div>
				<a href="#" class="navbar-brand"> Train Reservation System </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Train Schedules</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'> {{message}} </div> -->
		<div class="container">
			<h3 class="text-center">Train Schedules</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Train Schedule</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Train ID</th>
						<th>Train Name</th>
						<th>From Which Station</th>
						<th>To Which Station</th>
						<th>Price (Rs.)</th>
						<th>Departure Time</th>
						<th>Arrival Time</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="trainschedu" items="${listtrainSchedule}">

						<tr>
							<td><c:out value="${trainschedu.trainID}" /></td>
							<td><c:out value="${trainschedu.trainName}" /></td>
							<td><c:out value="${trainschedu.frmStation}" /></td>
							<td><c:out value="${trainschedu.toStation}" /></td>
							<td><c:out value="${trainschedu.price}" /></td>
							<td><c:out value="${trainschedu.departTime}" /></td>
							<td><c:out value="${trainschedu.arriveTime}" /></td>

							<td><a
								href="edit?id=<c:out value='${trainschedu.trainID}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${trainschedu.trainID}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>




































