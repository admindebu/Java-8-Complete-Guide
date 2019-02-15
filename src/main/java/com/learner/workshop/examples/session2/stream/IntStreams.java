package com.learner.workshop.examples.session2.stream;

/*
 * @Author Debu Paul
 */

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * IntStreams
 */
public class IntStreams {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}

		IntStream.range(0, 10).forEach(i -> {
			if (i % 2 == 1)
				System.out.println(i);
		});

		IntStream.range(0, 10).filter(i -> i % 2 == 1).forEach(System.out::println);

		OptionalInt reduced1 = IntStream.range(0, 10).reduce((a, b) -> a + b);
		System.out.println(reduced1.getAsInt());

		int reduced2 = IntStream.range(0, 10).reduce(7, (a, b) -> a + b);
		System.out.println(reduced2);

		List<Integer> distinctIntegers = IntStream.of(5, 6, 6, 6, 3, 2, 2).distinct().boxed()
				.collect(Collectors.toList());

		// IntStream boxed() returns a Stream consisting of the elements of this
		// stream, each boxed to an Integer

		System.out.println(distinctIntegers);
	}
}
