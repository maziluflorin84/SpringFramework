<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.trainings.spring.springmvc.dto.Employee,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List details</title>
</head>
<body>
<%
List<Employee> list = (List<Employee>) request.getAttribute("list");
for(Employee employee:list) {
	out.print(employee);
}
%>
</body>
</html>