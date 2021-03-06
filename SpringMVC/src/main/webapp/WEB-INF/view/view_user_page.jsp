<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/style.css" var="styleCSS" />
<link href="${styleCSS}" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		
		
		<div id="div1">
			<table id="table1">
			<tr>
				<th>email</th>
				<th>password</th>
			</tr>
			<tr>
				<td>${user.email}</td>
				<td>${user.password}</td>
		  	</tr>
		  	</table>
		 </div>
		 
		<div id="div2">
			<table id="table2">
			<tr>
				<th id="th2">COURSES</th>
			</tr>
			<c:forEach items="${listCourses}" var="singleCourse">
		   	 <tr>
				<td>${singleCourse.name}</td>
		  	</tr>
			</c:forEach>
			</table>
		</div>
		
		<div id="div3">
			<c:url var="manageLink" value="/begin/table"></c:url>
			<a href=${manageLink}>Back</a>
		</div>
	</div>
</body>
</html>