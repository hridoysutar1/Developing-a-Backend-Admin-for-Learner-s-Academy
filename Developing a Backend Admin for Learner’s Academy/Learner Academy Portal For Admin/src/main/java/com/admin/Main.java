package com.admin;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.info.*;
import com.info.Class;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DbConnection dbconnection;

	
	public void init() throws ServletException {

		super.init();

		try {
			dbconnection= new DbConnection();

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}
    
    public Main() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				try {

					// read the "command" parameter
					String command = request.getParameter("command");

					
						switch (command) {

						case "STUDENTS":
							studentsList(request, response);
							break;

						case "TEACHERS":
							teachersList(request, response);
							break;

						case "SUBJECTS":
							subjectList(request, response);
							break;

						case "CLASSES":
							classestList(request, response);
							break;



						default:
							classestList(request, response);

						}
					//}
				} catch (Exception e) {
					throw new ServletException(e);
				}
				// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	private void studentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Student> students = dbconnection.getStudents();

		// add students to the request
		request.setAttribute("STUDENT_LIST", students);

		// send it to the jsp view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentlist.jsp");
		dispatcher.forward(request, response);
		

	}
	
	
	
	private void teachersList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Teacher> teachers = dbconnection.getTeachers();

		// add students to the request
		request.setAttribute("TEACHERS_LIST", teachers);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacherlis.jsp");
		dispatcher.forward(request, response);

	}
	
	

	private void subjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get subjects from db util
		List<Subject> subjects = dbconnection.getSubjects();

		// add subjects to the request
		request.setAttribute("SUBJECTS_LIST", subjects);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subjectlist.jsp");
		dispatcher.forward(request, response);

	}
	
	

	private void classestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get subjects from db util
		List<Class> classes = dbconnection.getClasses();

		// add subjects to the request
		request.setAttribute("CLASSES_LIST", classes);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classreport.jsp");
		dispatcher.forward(request, response);

	}
}	
	
	
	
	
	
	


