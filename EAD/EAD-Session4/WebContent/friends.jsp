<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/friends.css">
<title>Friends</title>
</head>
<body>
	<%@ page import = "java.util.ArrayList" %>
	<%@include file="header.jsp" %>
	<% ArrayList<String> list = (ArrayList<String>)request.getAttribute("friendsList"); %>
	<% String mail = (String)session.getAttribute("email"); %>
	<div class="tableDiv">
		<table>
			<caption>Your Friends</caption>
			<%for(int index = 0 ; index<list.size(); index++){
				if(!mail.equals(list.get(index))){%>
			<tr>
				<td>
					<%= list.get(index) %>
				</td>
				<td>
					<a href="<%=request.getContextPath() %>/ViewProfile?uem=<%= list.get(index)%>">View Profile</a>
				</td>
			</tr>
			<%} }%>
		</table>
	</div>
</body>
</html>