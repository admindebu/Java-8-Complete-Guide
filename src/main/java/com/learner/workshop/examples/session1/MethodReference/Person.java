package com.learner.workshop.examples.session1.MethodReference;

/*
 * @Author Debu Paul
 */

public class Person {
	public String firstName;
	public String lastName;

	// No-Arg or Non-Parameterized Constractor
	public Person() {
	}

	// Parameterized constructor
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}