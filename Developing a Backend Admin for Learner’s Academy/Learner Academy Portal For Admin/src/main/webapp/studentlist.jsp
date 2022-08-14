<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.info.Student"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Students</title>
</head>

<div id="page" >
	

	
		<div id="wrapper">

			<div id="header">
				<h3>Students</h3>
			</div>
		</div>
<%  ArrayList <Student> sl=(ArrayList) request.getAttribute("STUDENT_LIST"); %>

		<div id="container">

			<div id="content">

				<table border="1">

					<tr>
                        <th>id</th>
						<th>Name</th>
						
						<th>class</th>
						

					</tr>

					<%
				if (!sl.isEmpty()) {
					Iterator<Student> iterator = sl.iterator();

					while (iterator.hasNext()) {
						Student st = iterator.next();
			%>
			<tr>
				<td><%=st.getId()%></td>
				<td><%=st.getName()%></td>
				<td><%=st.getClass_read()%></td>
			</tr>
			<%
				}
				}
					
			%>

				</table>
			</div>
		</div>
	</div>
</body>
</html>