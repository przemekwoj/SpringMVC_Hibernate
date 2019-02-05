<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="/resources/style.css" var="styleCSS" />
<link href="${styleCSS}" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		
		
		<div id="div1">
			<table id="table1">
			<tr>
				<th>id</th>
				<th>name</th>
			</tr>
			<tr>
				<td>${course.id}</td>
				<td>${course.name}</td>
		  	</tr>
		  	</table>
		 </div>
		 
		<div id="div2">
			<table id="table2">
			<tr>
				<th id="th2">USERS</th>
			</tr>
			<c:forEach items="${listUsers}" var="singleUser">
		   	 <tr>
				<td>${singleUser.email}</td>
		  	</tr>
			</c:forEach>
			</table>
		</div>
		
		<div id="div3">
			<c:url var="manageLink" value="/course/showCoursesForm"></c:url>
			<a href=${manageLink}>Back</a>
		</div>
	</div>
</body>
</html>