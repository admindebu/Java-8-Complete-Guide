package com.learner.workshop.examples.session1.funtional_interface;

/*
 * @Author Debu Paul
 */

import java.util.function.Predicate;

public class TestPredicate {

	public static void main(String[] args) {
		String value = "peter";
		int value2 = 2;

		Predicate predicate = (a) -> a != null;
		Predicate predicate2 = (b) -> b instanceof String;

		// tests the predicate conditions
		System.out.println(predicate.test(value));

		// negate the predicate conditions
		System.out.println(predicate.negate().test(value));

		// check both the predicate conditions and print the 'or' condition
		// results
		System.out.println(predicate.or(predicate2).test(value));

		// check both the predicate conditions and print the 'and' condition
		// results
		System.out.println(predicate.and(predicate2).test(value2));
	}
}
