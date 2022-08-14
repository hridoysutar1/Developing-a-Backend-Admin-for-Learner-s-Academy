package com.info;

public class Student {
  private int id;
  private String name;
  private int class_read;
  
  
  
public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public int getClass_read() {
	return class_read;
}



public void setClass_read(int class_read) {
	this.class_read = class_read;
}




public Student(int id, String name, int class_read) {
	super();
	this.id = id;
	this.name = name;
	this.class_read = class_read;
}
public Student(String name) {
	this.name=name;
}



public Student() {
	super();
	
}
  
  
  
}
