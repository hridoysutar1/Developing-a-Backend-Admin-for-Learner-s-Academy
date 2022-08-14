package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.info.Class;
import com.info.Student;
import com.info.Subject;
import com.info.Teacher;


public class DbConnection {
	

	public List<Student> getStudents() throws SQLException {

		List<Student> students = new ArrayList<>();


		try {
    
			Connection con=DB.getMyConnection();
			Statement myStmt = null;
			ResultSet myRs = null;
			// create sql stmt
			String sql = "SELECT * FROM students";
			myStmt = con.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				
				
				int class_read = myRs.getInt("class_read");

				// create new student object
				Student tempStudent = new Student(id, name, class_read);

				// add it to the list of students
				students.add(tempStudent);

			}
			con.close();
			myStmt.close();
			myRs.close();
			
			
      
		} catch (Exception e) {
			e.getStackTrace();
		} 
		
		
		return students;

	}

	public List<Teacher> getTeachers() {

		List<Teacher> teachers = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
        Connection con=DB.getMyConnection();
		try {

			
			// create sql stmt
			String sql = "SELECT * FROM teachers";
			myStmt = con.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				
				int age = myRs.getInt("age");

				// create new student object
				Teacher temp = new Teacher(id, name, age);

				// add it to the list of students
				teachers.add(temp);

			}
			con.close();

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			// close JDBC objects
			close(con, myStmt, myRs);
		}
		return teachers;
	}

	public List<Subject> getSubjects() {

		List<Subject> subjects = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			
			Connection con=DB.getMyConnection();

			// create sql stmt
			String sql = "SELECT * FROM subjects";
			myStmt = con.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				String code = myRs.getString("code");

				// create new student object
				Subject temp = new Subject(id, name,code);

				// add it to the list of students
				subjects.add(temp);

			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return subjects;

	}
	

	public List<Class> getClasses() {

		List<Class> classes = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			
			Connection con=DB.getMyConnection();

			// create sql stmt
			String sql = "SELECT * FROM classtable";
			myStmt = con.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String teacher = myRs.getString("teacher");
				String subject = myRs.getString("subject");
				

				Class temp = new Class(id, teacher, subject);

				// add it to the list of students
				classes.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
			
		}
		return classes;

	}
	

	public List<Student> loadClassStudents(int classId) {

		List<Student> students = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			Connection con=DB.getMyConnection();

			// create sql stmt
			String sql = "SELECT * FROM students WHERE class_read = " + classId;
			myStmt = con.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				
				int class_read = myRs.getInt("class_read");

				// create new student object
				Student tempStudent = new Student(id, name,class_read);
				students.add(tempStudent);

			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		return students;

	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

}