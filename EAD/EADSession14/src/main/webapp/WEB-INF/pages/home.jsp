<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Student Application</title>
	<style>
		div{
			font-size: 30px;
			background-color: antiquewhite;
			padding: 5%;
		}
		.msg{
			font-size:20px;
			padding-left:150px;
			padding-top:50px;
			color:green;
		}
		.msg-error{
			font-size:20px;
			padding-left:150px;
			padding-top:50px;
			color:red;
		}
	</style>
	 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body style="background-color: antiquewhite">
	

	<span class="msg">${success}</span>
	<span class="msg-error">${warn}</span>
  		
	<div>
		<a href="signup"> Add Student</a>
	</div>
	<div>
		<a href="showAll">Show All Student</a>
	</div>
	<div>
		<a href="<c:url value='/logout' />">Click here to logout</a>
	</div>	
	 
</body>
</html>