<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Searched Students</title>
<link rel="stylesheet" href="css/studentDisplay.css">

<script type="text/javascript">
	
	function filterResult(){
		document.getElementById("tableDiv").style.display="";
		document.getElementById("error").innerHTML="";
		  var count = 0;
		  filter = document.getElementById("selectClass").value;
		  table = document.getElementById("myTable");
		  tr = table.getElementsByTagName("tr");
		  for (var index = 1; index < tr.length; index++) {
		    var tds = tr[index].getElementsByTagName("td");
		    var flag = false;
		    if(tds.length==6){
		      var td = tds[4];
		      var value = td.innerText;
		      value = value.trim();
		      if (filter.localeCompare(value) == 0 || filter=="0") {
		        flag = true;
		      } 
		    }
		    if(flag){
		        tr[index].style.display = "";
		        count++;
		    }
		    else {
		        tr[index].style.display = "none";
		    }
		  }
		  
		  if(count==0){
			  document.getElementById("tableDiv").style.display="none";
			  document.getElementById("error").innerHTML = "No result Found";
		  }
	}
				

	
	</script>
</head>
<body>
		<%@ page import = " java.util.ArrayList" %>
		<%@ page import = " com.database.Student" %>
		<% ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("studentList");
		%>
		<a href="index.html">Back to Home</a>
		<div align="center" onchange="filterResult()"> Filter By Class	
			<select id="selectClass">
				<option value="0">All</option>
				<%
				for(int index=1; index<13; index++){	
				%>
				<option value=<%= index %>> <%=index %></option>
				<% }  %>
			</select>
		</div>
		
	<div id="tableDiv">
		<table id="myTable">
			<th>FirstName</th>
			<th>Last Name</th>
			<th>Father Name</th>
			<th>Email</th>
			<th>Class</th>
			<th>Age</th>
			<%
			for(int i=0; i<list.size(); i++){	
			%>
			<tr>
				<td> <%= list.get(i).getFirstName() %> </td>
				<td> <%=list.get(i).getLastName() %> </td>
				<td> <%=list.get(i).getFatherName() %> </td>
				<td> <%=list.get(i).getEmail() %> </td>
				<td> <%=list.get(i).getClassNo() %> </td>
				<td> <%=list.get(i).getAge() %> </td>
			<tr>
			<% }  %>
	
		</table>
	</div>
	<h2 align="center" id="error"></h2>
	
</body>
</html>