<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="saveUser" modelAttribute="user" method="POST">

			<table>
				<tbody>
					<tr>
						<td><label>email:</label></td>
						<td><form:input path="email"/></td> ${error}
					</tr>
				
					<tr>
						<td><label>password:</label></td>
						<td><form:input path="password"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
</body>
</html>