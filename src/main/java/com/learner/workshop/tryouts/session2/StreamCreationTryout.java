package com.learner.workshop.tryouts.session2;

/*
 * @Author Debu Paul
 */

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationTryout {

	public static void main(String[] args) throws IOException {
		test1();
		test2();
		test3();
		test4();
	}

	private static void test4() {
		// Create Stream of two BigDecimals, map them to double and compute
		// average

	}

	private static void test3() {
		// Use IntStream from a range and compute average
	}

	private static void test2() {
		// Use IntStreamBuilder and compute average

	}

	private static void test1() {
		int[] ints = { 1, 3, 5, 7, 11 };
		// Using Array streams, calculate the average of the ints
	}
}
