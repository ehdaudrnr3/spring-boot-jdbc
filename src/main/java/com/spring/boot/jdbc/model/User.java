package com.spring.boot.jdbc.model;

public class User {

	private String username;
	private String passwrod;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public User() {
	}

	public User(String username, String passwrod, int age) {
		this.username = username;
		this.passwrod = passwrod;
		this.age = age;
	}

}
