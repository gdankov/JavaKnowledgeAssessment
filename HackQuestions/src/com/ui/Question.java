package com.ui;

public class Question {

	public String name = "What is ..........?";
	public String a = "a is ..........";
	public String b = "b is ..........";
	public String c = "c is ..........";
	public String d = "d is ..........";

	public Question(String a, String b, String c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public String getName() {
		return name;
	}

	public String getA() {
		return a;
	}

	public String getB() {
		return b;
	}

	public String getC() {
		return c;
	}

	public String getD() {
		return d;
	}

}
