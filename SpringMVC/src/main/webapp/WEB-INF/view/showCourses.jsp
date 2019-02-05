<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
				<tr>
					<th>lp</th>
					<th>name</th>
				</tr>
				
				<c:set var="count" value="0" scope="page" />
				
				<c:forEach var="tempCourses" items="${allCourses}">
				
					
					
					<c:url var="viewLink" value="/course/view">
						<c:param name="courseId" value="${tempCourses.id}" />
					</c:url>				

					<c:url var="deleteLink" value="/course/delete">
						<c:param name="courseId" value="${tempCourses.id}" />
					</c:url>
					
					<c:set var="count" value="${count + 1}" scope="page"/>
					
					<tr>
							<td> ${count}</td>
							<td> ${tempCourses.name} </td>
							<td>
							<!-- display the update link -->
							<a href="${viewLink}">View</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this Course?'))) return false">Delete</a>
							</td>
							
					</tr>
				</c:forEach>
	</table>
	<br>
	<c:url var="manageLink" value="/begin/table">
	</c:url>
	<a href=${manageLink}>Back</a>
</body>
</html>