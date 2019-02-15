package com.learner.workshop.examples.session4;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/*
 * @Author Debu Paul
 */

public class Challenges {
	public static void main(String[] args) {
		// Debugging Lambdas
		List<String> strings = Arrays.asList("", "abc");

		strings.stream().map(str -> getLength(str)).forEach(System.out::println);

		for (String string : strings) {
			getLength(string);
		}

		// Checked Exceptions and Lambda
		strings.forEach(s -> {

			try {
				writeToFile(s);
			} catch (IOException e) {
				throw new RuntimeException();
			}
		});
	}

	private static int getLength(String input) {
		if ("".equals(input)) {
			throw new IllegalArgumentException();
		}

		return input.length();
	}

	private static boolean writeToFile(String text) throws IOException {
		// write to a file

		return true;
	}
}