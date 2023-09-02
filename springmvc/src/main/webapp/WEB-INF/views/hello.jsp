<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>
</head>
<body>

	<%
	Integer id = (Integer) request.getAttribute("id");
	String name = (String) request.getAttribute("name");
	Integer salary = (Integer) request.getAttribute("salary");
	// out.print(id + " " + name + " " + salary);
	%>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
		</tr>
		<tr>
			<td>${id}</td>
			<td>${name}</td>
			<td>${salary}</td>
		</tr>
	</table>

</body>
</html>