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

	<c:url var="manageLink" value="/begin/table"></c:url>
	
	<a href=${manageLink}>Back</a>
	  ${user.email} " " ${user.password} " <c:out value="${listCourses[0].name}"/> "" 
	<c:forEach items="${listCourses}" var="singleCourse">    
   	 <c:out value="${singleCourse.name}"/>
	</c:forEach>
	
</body>
</html>