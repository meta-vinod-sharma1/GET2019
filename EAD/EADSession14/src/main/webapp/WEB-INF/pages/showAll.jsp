<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students</title>
</head>
<body>

<a href="/home">Go back to home</a>
<div class="container" style="margin-top: 60px">
	<div class="card">
		</div>
			<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Father Name</th>
						<th>Email</th>
						<th>class</th>
						<th>age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="student">
						<tr>
							<td>${student.id}</td>
							<td>${student.fName}</td>
							<td>${student.lName}</td>
							<td>${student.fatherName}</td>
							<td>${student.email}</td>
							<td>${student.classNo}</td>
							<td>${student.age}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			<div>
		</div>
</div>
</body>
</html>