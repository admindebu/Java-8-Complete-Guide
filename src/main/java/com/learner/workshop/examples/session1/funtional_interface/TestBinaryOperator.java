package com.learner.workshop.examples.session1.funtional_interface;

/*
 * @Author Debu Paul
 */

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class TestBinaryOperator {

	public static void main(String[] args) {
		// binary operator with lambda, takes 2 input of same type argument and
		// return the object of argumnet type.
		BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;
		System.out.println(adder.apply(3, 4));

		// anaymous implementation
		BinaryOperator<Integer> adder2 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer integer, Integer integer2) {
				return integer + integer2;
			}
		};
		System.out.println(adder2.apply(5, 4));

		// other static methods in binary operator.
		BinaryOperator b1 = BinaryOperator.minBy(Comparator.reverseOrder());
		BinaryOperator b2 = BinaryOperator.maxBy(Comparator.reverseOrder());
		System.out.println(b1.apply(4, 3));
		System.out.println(b2.apply(4, 3));
	}
}
