package com.tutorial.model;


public class Details {
	private String firstName;
	private String lastName;
	private int age;
	private String score;

	public Details(){
		
	}
	
	public Details(String firstName, String lastName, String score, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
}
