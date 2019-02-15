package com.learner.workshop.examples.session1.lambda;

/*
 * @Author Debu Paul
 */

import java.util.*;

public class Lambda1 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		// Sorting with out using Lambda Expression
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});

		// Lamda function invoke of Comparator ( Functional interface of
		// compareTo method
		Collections.sort(names, (a, b) -> {
			return b.compareTo(a);
		});
		// Simplification of Lambda Expression
		Collections.sort(names, (String a, String b) -> b.compareTo(a));

		// More simplification of Lambda Expression

		Collections.sort(names, (a, b) -> b.compareTo(a));

		System.out.println(names);

		List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
		// Using Method reference more readable than Lambda Expression
		names2.sort(Comparator.nullsLast(String::compareTo));
		System.out.println(names2);

		List<String> names3 = null;

		// Use of Optional Class ( which is introduce in Java -8 , we will
		// discuss later)
		Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));

		System.out.println(names3);
	}

}