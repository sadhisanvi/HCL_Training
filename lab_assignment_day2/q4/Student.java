package com.day2.q4;

public class Student {
	private String name;
	private String id;
	private double grade;
	public Student(String name, String id,double grade) { 
		this.name = name;
		this.id = id;
		this.grade = grade;
	}
	public Student(String name, String id) {
		this(name,id,0.0);
		this.name = name;
		this.id = id;
	}
	public Student(String id) {
		this(" ",id);
		this.id = id;
	}
	
	public void display() {
		System.out.println("Name :"+name+" Id :"+id+" Grade:"+grade);
	}
	
	public void display(int year) {
		this.display();
		System.out.println("Year: "+year);
	}
}
