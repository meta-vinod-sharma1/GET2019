 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	

	<div>	
	<table >
		<table>
			<caption>Details</caption>
			<tr>
				<td>Name</td>
				<td>${profile.getName()}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${ profile.getEmail()}</td>
			</tr>
			<tr>
				<td>PhoneNumber</td>
				<td>${ profile.getPhoneNumber()}</td>
			</tr>
			<tr>
				<td>Vehicle Number</td>
				<td>${profile.getVehicleNumber()}</td>
			</tr>
			<tr>
				<td>Organization</td>
				<td>${profile.getOrganization()}</td>
			</tr>

		</table>
	</div>

</body>
</html> 