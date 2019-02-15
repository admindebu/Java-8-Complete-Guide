package com.learner.workshop.examples.session4;

import java.util.stream.Collectors;

/*
 * @Author Debu Paul
 */

public class Strings {
	public static void main(String[] args) {
		String dob = String.join("-", "29", "Dec", "1992");

		System.out.println("dob = " + dob);

		String distinctChars = "foobar:foo:bar".chars().distinct().mapToObj(c -> String.valueOf((char) c)).sorted()
				.collect(Collectors.joining());

		System.out.println("distinctChars = " + distinctChars);
	}
}
