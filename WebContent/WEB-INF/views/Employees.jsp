<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="my.objects.Employee"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
<style>
h1 {text-align:center;}
</style>
</head>
<body>
<div><h1>Employees</h1></div>

<% Map<String, Employee> employees = (Map<String, Employee>)request.getAttribute("employees");
 	if(employees != null){
    	for(Entry<String, Employee> entry : employees.entrySet())
    	{
    		Employee employee = entry.getValue();
 			out.print("<div name=${employee.getId()}>" );
        	out.print("First: " + employee.getFirstName() + "      ");
        	out.print("Last: " + employee.getLastName() + "            ");
        	out.print("Position: " + employee.getPosition() + "            ");
        	out.print("<button type=\"submit\" name=\"view\">view</button>");
        	out.print("</div>");
        	out.print("<br/>");
        	out.print("<br/>");
    	}
 	}
%>

</body>
</html>