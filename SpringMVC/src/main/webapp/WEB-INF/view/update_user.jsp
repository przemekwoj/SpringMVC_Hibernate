<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="UpdateUser" modelAttribute="user" method="POST">
	     
			<form:hidden path="id" value="${user.id}" />
					
			<table>
				<tbody>
					<tr>
						<td><label>email:</label></td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						<td><label>password:</label></td>
						<td><form:input path="password"/></td>
					</tr>
					<tr>
						<td><label>
						<c:forEach var="tempCourses" items="${allCourses}">
							<input type="checkbox" name="checkbox" value="${tempCourses.id}">
							${tempCourses.name}
							<br>
						</c:forEach>
						</label></td>
						<td><input type="submit" value="update"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	<c:url var="manageLink" value="/begin/table">
	</c:url>
	<a href=${manageLink}>Back</a>
</body>
</html>