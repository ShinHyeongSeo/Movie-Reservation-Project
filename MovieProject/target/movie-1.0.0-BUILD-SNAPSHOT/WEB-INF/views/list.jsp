<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mycom.movie.board.BoardDAO,com.mycom.movie.board.BoardVO,java.util.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
   integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
   crossorigin="anonymous">
  
<title>Movie Reservation</title>
<style>

#seats {
	margin:100px;
	text-align:center;
}
.btn btn-outline-primary{
	margin:30px;
}
#a1{
	margin:30px;
	padding:50px;
	font-size:large;
}


</style>
<script>
	function delete_ok(id) {
		var a = confirm("정말로 삭제하겠습니까?");
	    if(a) location.href='./deleteok/'+id;
	}
</script>

</head>
<body>
<br>
<h1 align = "center"><strong>MOVIE RESERVATION SERVICE</strong></h1>
<br>
<form:form method = "POST" modelAttribute = "u" action="add" id="seats">
	<input id="a1" type="submit" name = "seat" value = "A1" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "A2" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "A3" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "A4" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "A5" class="btn btn-outline-primary">
	<br>
	<input id="a1" type="submit" name = "seat" value = "B1" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "B2" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "B3" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "B4" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "B5" class="btn btn-outline-primary">
	<br>
	<input id="a1" type="submit" name = "seat" value = "C1" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "C2" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "C3" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "C4" class="btn btn-outline-primary">
	<input id="a1" type="submit" name = "seat" value = "C5" class="btn btn-outline-primary">
</form:form>
<div class="table-responsive-sm">
 <table  align = "center" style="width:70%"  class="table table-hover"id="list">
<tr class="table table-sm">
	<th>No</th>
	<th>Name</th>
	<th>ID</th>
	<th>Seat</th>
	<th></th>
	<th></th>
	<th></th>
</tr>


<c:forEach items="${list}" var="u">
	<tr class="table table-sm">
		<td>${u.seq}</td>
		<td>${u.username}</td>
		<td>${u.userid}</td>
		<td>${u.seat}</td>
		<td style="width:70px;"><a class="btn btn-light" href="viewform/${u.seq}">View</a></td>
		<td style="width:70px;"><a class="btn btn-success" href="editform/${u.seq}">Edit</a></td>
		<td style="width:70px;"><a class="btn btn-danger" href="javascript:delete_ok('${u.seq}')">Delete</a></td>
	</tr>
</c:forEach>
</table>
</div>
</body>
</html>