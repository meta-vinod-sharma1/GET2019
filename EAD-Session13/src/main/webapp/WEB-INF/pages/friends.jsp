<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/friends.css">
<title>Friends</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="tableDiv">
		<table>
			<caption>Your Friends</caption>
			<c:forEach items="${list}" var="friend">
						<tr>
							<td>${friend}</td>
							<td><a href="viewProfile?email=${friend}">View Profile</a></td>
							
						</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>