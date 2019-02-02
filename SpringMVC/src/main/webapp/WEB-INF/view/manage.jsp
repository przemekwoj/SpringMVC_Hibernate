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
					<th>email</th>
					<th>password</th>
				</tr>
				
				<c:set var="count" value="0" scope="page" />
				
				<c:forEach var="tempUser" items="${allUsers}">
				
					<c:url var="updateLink" value="/user/update">
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>	
					
					<c:url var="viewLink" value="/user/view">
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>				

					<c:url var="deleteLink" value="/user/delete">
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>
					
					<c:set var="count" value="${count + 1}" scope="page"/>
					
					<tr>
							<td> ${count}</td>
							<td> ${tempUser.email} </td>
							<td> ${tempUser.password} </td>
							<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${viewLink}">View</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
							</td>
							
					</tr>
				</c:forEach>
	</table>
	
	
	<c:url var="addUserLink" value="/user/addUserForm"></c:url>

	 	<input type="submit"  value="add User"
	onclick="window.location.href='${addUserLink}','_blank'">
	 
	 
	 <c:url var="addCourseLink" value="/course/addCourseForm"></c:url>

	 	<input type="submit" value="add Course"
	onclick="window.location.href='${addCourseLink}','_blank'">
	
</body>
</html>