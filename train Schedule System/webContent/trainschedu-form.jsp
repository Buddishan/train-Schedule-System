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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${trainschedu != null}">
				<form action="update" method="post">
				</c:if>
				
				<c:if test="${trainschedu == null}">
					<form action="insert" method="post">
				</c:if>
				
				<caption>
					<h2>
						<c:if test="${trainschedu != null}">
            			Edit Train Schedule
            		</c:if>
						<c:if test="${trainschedu == null}">
            			Add New Train Schedule
            		</c:if>
					</h2>
				</caption>
				
				<c:if test="${trainschedu != null}">
					<input type="hidden" name="trainID" value="<c:out value='${trainschedu.trainID}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Train Name</label> <input type="text"
						value="<c:out value='${trainschedu.trainName}' />" class="form-control"
						name="trainName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label for="browser">From Which Station:<input list="status" value="<c:out value='${trainschedu.frmStation}' />" class="form-control" name="frmStation" required="required"></label><br>
					<datalist id="status">
						<select required>
							<option>Colombo Fort</option>
							<option>Maradana</option>
							<option>Beliatta</option>
							<option>Matara</option>
							<option>Kandy</option>
							<option>Galle</option>
							<option>Kurunegala</option>
							<option>Anuradapura</option>
							<option>Jaffna</option>
							<option>Vavuniya</option>
							<option>Batticaloa</option>
							<option>Badulla</option>
							<option>Trincomalee</option>
							<option>Polgahawela</option>
							<option>Bandarawela</option>
							<option>Ella</option>
							<option>Hatton</option>
							<option>Ragama</option>
							<option>Kankasanthurai</option>
						</select>
					</datalist>
				</fieldset>
				
				<fieldset class="form-group">
					<label for="browser">To Which Station:<input list="status" value="<c:out value='${trainschedu.toStation}'/>" class="form-control" name="toStation" required="required"></label><br>
					<datalist id="status">
						<select required>
							<option>Colombo Fort</option>
							<option>Maradana</option>
							<option>Beliatta</option>
							<option>Matara</option>
							<option>Kandy</option>
							<option>Galle</option>
							<option>Kurunegala</option>
							<option>Anuradapura</option>
							<option>Jaffna</option>
							<option>Vavuniya</option>
							<option>Batticaloa</option>
							<option>Badulla</option>
							<option>Trincomalee</option>
							<option>Polgahawela</option>
							<option>Bandarawela</option>
							<option>Ella</option>
							<option>Hatton</option>
							<option>Ragama</option>
							<option>Kankasanthurai</option>
						</select>
					</datalist>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Price (Rs.)</label> <input type="number"
						value="<c:out value='${trainschedu.price}' />" class="form-control"
						name="Price" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Departure Time</label> <input type="time"
						value="<c:out value='${trainschedu.departTime}' />" class="form-control"
						name="departTime" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Arrival Time</label> <input type="time"
						value="<c:out value='${trainschedu.arriveTime}' />" class="form-control"
						name="arriveTime" required="required">
				</fieldset>
				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>


























