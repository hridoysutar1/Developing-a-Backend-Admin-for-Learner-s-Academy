package com.info;

public class Class {
	private int id;
	private String teacher;
	private  String subject;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	public Class(int id, String teacher, String subject) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.subject = subject;
	}
	public Class() {
		super();
		
	}
	

}
