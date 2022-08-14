<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.info.Teacher"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Teacher</title>
</head>
<body style="background-image: url('css/background.jpg');">
<div id="page" >
	
	
		<div id="wrapper">

			<div id="header">
				<h3>Teachers</h3>
			</div>
		</div>
<%  ArrayList <Teacher> sl=(ArrayList) request.getAttribute("TEACHERS_LIST"); %>

		<div id="container">

			<div id="content">

				<table border="1">

					<tr>
                        <th>Id</th>
						<th>Name</th>
						
						<th>Age</th>
						

					</tr>

					<%
				if (!sl.isEmpty()) {
					Iterator<Teacher> iterator = sl.iterator();

					while (iterator.hasNext()) {
						Teacher st = iterator.next();
			%>
			<tr>
				<td><%=st.getId()%></td>
				<td><%=st.getName()%></td>
				<td><%=st.getAge()%></td>
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