package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("name");
		String pword=request.getParameter("password");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher rd;
		//username= "admin" password="123456"
		if(uname.equalsIgnoreCase("admin") && pword.equals("123456")){
			
		
		rd=request.getRequestDispatcher("Report.jsp");
		rd.forward(request, response);
		}
		else {
			out.println("Invalid Username or Password Try Again");
			rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}

}
