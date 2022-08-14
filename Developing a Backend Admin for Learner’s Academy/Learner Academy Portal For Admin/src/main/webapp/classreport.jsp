<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.info.Class"%>
<%@page import="com.info.Student"%>
<%@page import="com.admin.DbConnection"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Subjects</title>
</head>
<body style="background-image: url('css/background.jpg');">
<div id="page" >
	

	
		<div id="wrapper">

			<div id="header">
				<h3>Class Report</h3>
			</div>
		</div>
<%  ArrayList <Class> sl=(ArrayList) request.getAttribute("CLASSES_LIST");
    
DbConnection dbcon=new DbConnection();

%>

		<div id="container">

			<div id="content">

				<table border="1">

					<tr>
                        <th>Id</th>
						<th>Teacher Name</th>
						<th>Subject</th>
						<th>Student List</th>
						

					</tr>

					<%
				if (!sl.isEmpty()) {
					Iterator<Class> iterator = sl.iterator();

					while (iterator.hasNext()) {
					  Class st = iterator.next();
					  
			%>
			<tr>
				<td><%=st.getId()%></td>
				
				<td><%=st.getTeacher()%></td>
				<td><%=st.getSubject()%></td>
				<td><%   ArrayList <Student> ar= (ArrayList)dbcon.loadClassStudents(st.getId());
				     for(int i=0;i<ar.size();i++){
				    	 out.print(ar.get(i).getName()+", ");
				     }			
				%></td>
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