<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy</title>
</head>
<body>
    <h3 >Welcome Admin</h3>
	<div class="sidenav" position="centre">
	
	<c:url var="classesLink" value="Main">
		<c:param name="command" value="CLASSES" />
	</c:url>

	<c:url var="subjectsLink" value="Main">
		<c:param name="command" value="SUBJECTS" />
	</c:url>

	<c:url var="teachersLink" value="Main">
		<c:param name="command" value="TEACHERS" />
	</c:url>

	<c:url var="studentsLink" value="Main">
		<c:param name="command" value="STUDENTS" />
	</c:url>

	    <a class="bar-item" href="${classesLink}">Classes</a> <br>
	    
		<a class="bar-item" href="${subjectsLink}">Subjects</a> <br> 
		<a class="bar-item" href="${teachersLink}">Teachers</a> <br> 
		<a class="bar-item" href="${studentsLink}">Students</a> <br>  <br> 
		<a class="bar-item" href="logout.jsp">Log out</a> <br> <br>

</div>

	
</body>
</html>