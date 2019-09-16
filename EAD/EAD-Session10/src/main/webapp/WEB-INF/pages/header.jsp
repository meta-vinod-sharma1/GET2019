<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/header.css">
<title>Metacube Parking System</title>
</head>
<body>
	<div class="logo">
		<div style="float: left; width: 40%; margin: auto">
				<% if(session.getAttribute("email")!= null){ %>
					<span><%=session.getAttribute("email")%></span> 
					
				<%}else{ %>
					<span>not logged in</span>
				<%} %>
		</div>
		<div style="width: 60%; margin: auto; padding-left: 5px;">
			
			Meta<span class="logoBlue">cube</span>Parking System
			
			
		</div>
		
		
			

	</div>
	<div class="ifLogin">
			
	</div>
	<div>
		<ul>
			<li><a href="home">Home</a></li>
			<li><a href="friends"> Friends</a></li>
			<li><a href="editProfile"> Edit profile</a></li>
			<li><a href="viewProfile?email=<%= session.getAttribute("email")%>">View profile</a></li>
			<li><a href="#contact">Contact</a></li>
			<li><a href="#about">About</a></li>
			
			<li class="log">
					<% if(session.getAttribute("email")!= null){ %>
						
						<a href="logout">Log Out</a>
					<%}else{ %>
						
						<a href="login">Log in</a>
						
					<%} %>
			</li>
			<li class="log"><% if(session.getAttribute("email")!= null){ %>
							
						<a class="imgA" href="uploadPhoto">
 							<img src="images/<%=session.getAttribute("image")%>" alt="profile picture" style="display: inline-block; width:42px;height:42px;">
						</a>
								
						<%} %>
					</li>
		  </ul>
	</div>	
</body>
</html>