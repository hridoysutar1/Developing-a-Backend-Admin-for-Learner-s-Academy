<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    
<%@page import="com.info.Subject"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Subjects</title>
</head>
<div id="page" >
	

	
		<div id="wrapper">

			<div id="header">
				<h3>All Subjects</h3>
			</div>
		</div>
<%  ArrayList <Subject> sl=(ArrayList) request.getAttribute("SUBJECTS_LIST"); %>

		<div id="container">

			<div id="content">

				<table border="1">

					<tr>
                        <th>Id</th>
						<th>Subject Name</th>
						
						<th>Code</th>
						

					</tr>

					<%
				if (!sl.isEmpty()) {
					Iterator<Subject> iterator = sl.iterator();

					while (iterator.hasNext()) {
						Subject st = iterator.next();
			%>
			<tr>
				<td><%=st.getId()%></td>
				<td><%=st.getName()%></td>
				<td><%=st.getCode()%></td>
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