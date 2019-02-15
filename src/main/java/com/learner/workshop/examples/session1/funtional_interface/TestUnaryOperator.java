package com.learner.workshop.examples.session1.funtional_interface;

/*
 * @Author Debu Paul
 */

import java.util.function.UnaryOperator;

public class TestUnaryOperator {

	public static void main(String[] args) {
		String name = "peter";
		UnaryOperator operator = a -> "hello, " + a;

		// Get identity of the unary operator
		System.out.println(UnaryOperator.identity().apply(name));

		// Apply operations on the unary operator
		System.out.println(operator.apply(name));

	}
}
