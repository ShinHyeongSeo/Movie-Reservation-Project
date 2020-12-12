<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style>
body {
	align: center;
}

form_main {
	width: 100%;
}

.form_main h4 {
	font-family: roboto;
	font-size: 20px;
	font-weight: 300;
	margin-bottom: 15px;
	margin-top: 20px;
	text-transform: uppercase;
}

.heading {
	border-bottom: 1px solid #fcab0e;
	padding-bottom: 9px;
	position: relative;
}

.heading span {
	background: #9e6600 none repeat scroll 0 0;
	bottom: -2px;
	height: 3px;
	left: 0;
	position: absolute;
	width: 75px;
}

.form {
	border-radius: 7px;
	padding: 6px;
}

.txt[type="text"] {
	border: 1px solid #ccc;
	margin: 10px 0;
	padding: 10px 0 10px 5px;
	width: 100%;
}

.pw[type="password"] {
	border: 1px solid #ccc;
	margin: 10px 0;
	padding: 10px 0 10px 5px;
	width: 100%;
}

.txt_3[type="text"] {
	margin: 10px 0 0;
	padding: 10px 0 10px 5px;
	width: 100%;
}

.txt2[type="submit"] {
	background: #242424 none repeat scroll 0 0;
	border: 1px solid #4f5c04;
	border-radius: 25px;
	color: #fff;
	font-size: 16px;
	font-style: normal;
	line-height: 35px;
	margin: 10px 0;
	padding: 0;
	text-transform: uppercase;
	width: 30%;
}

.txt2:hover {
	background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
	color: #5793ef;
	transition: all 0.5s ease 0s;
}
</style>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Reservation</title>

</head>
<body>
	<div class="row" align="center">
		<div class="col-md-15">
			<div class="form_main">
				<h1 class="heading">
					<strong>Edit</strong> Reservation<span></span>
				</h1>
				<div class="form" align="center">
					<form:form method="POST" modelAttribute="u" action="../editok">
						<table align="center">
							<tr>
								<td></td>
								<td><form:hidden path="seq" /></td>
							</tr>

							<tr>
								<td>Name :</td>
								<td><form:input required="" class="txt"
										placeholder="Name..." path="username" /></td>

							</tr>


							<tr>
								<td>Phone :</td>
								<td><form:input required="" class="txt"
										placeholder="Phone..." path="phone" /></td>

							</tr>
							<tr>
								<td>ID :</td>
								<td><form:input required="" class="txt" placeholder="ID..."
										path="userid" /></td>

							</tr>
							<tr>
								<td>Password :</td>
								<td><form:password required="" class="pw"
										placeholder="Password" path="password" /></td>

							</tr>
							<tr>
								<td>Seat :</td>
								<td><form:input required="" class="txt"
										placeholder="Seats..." path="seat" /></td>

							</tr>



						</table>
						<br>
						<br>
						<input class="btn btn-light" type="submit" value="Edit Save" />
						<button style="margin-left : 30px" class="btn btn-light" type="button"
									onclick="location.href = '../list'">Go Back</button>
						
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>