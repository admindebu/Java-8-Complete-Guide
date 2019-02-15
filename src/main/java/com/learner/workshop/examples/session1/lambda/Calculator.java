package com.learner.workshop.examples.session1.lambda;

/*
 * @Author Debu Paul
 */

public interface Calculator {
	// Define normal abstract method
	int calculate(int x);

	// Define default method 1
	default void name(String name) {
		System.out.println("Calculator name: " + name);
	}

	// Define default method 2
	default boolean positive(int a) {
		return a > 0 ? true : false;
	}
}
