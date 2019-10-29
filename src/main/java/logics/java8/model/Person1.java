package com.java8.practice;

public class Person1 {

	private String name;
	
	private int age;
	
	public Person1() {

	}
	
	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "Person [" + name + ", " + age + "]";
	}
	
}
