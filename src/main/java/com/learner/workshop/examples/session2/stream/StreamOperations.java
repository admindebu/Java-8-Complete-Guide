package com.learner.workshop.examples.session2.stream;

/*
 * @Author Debu Paul
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * All stream operations
 */
public class StreamOperations {

	public static void main(String[] args) {

		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		// filtering

		stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);

		// "aaa2", "aaa1"

		// sorting

		stringCollection.stream().filter((s) -> s.startsWith("a")).sorted().forEach(System.out::println);

		// "aaa1", "aaa2"

		// mapping

		stringCollection.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a))
				.forEach(System.out::println);

		// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"

		// matching

		boolean anyStartsWithA = stringCollection.stream().anyMatch((s) -> s.startsWith("a"));

		System.out.println(anyStartsWithA); // true

		boolean allStartsWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));

		System.out.println(allStartsWithA); // false

		boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));

		System.out.println(noneStartsWithZ); // true

		// first match
		Optional<String> val = Stream.of("one", "two").findFirst();
		System.out.println(val);

		// find any
		Optional<String> value = Stream.of("one", "two", "45", "three", "four", "789").findAny();
		System.out.println(value);

		// Counting

		long startsWithB = stringCollection.stream().filter((s) -> s.startsWith("b")).count();

		System.out.println(startsWithB); // 3

		// Reducing

		Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);

		reduced.ifPresent(System.out::println);
		// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"

		// Using limit
		List<String> vals = Stream.of("limit", "by", "two").limit(2).collect(Collectors.toList());
		System.out.println("Limit ::: " + vals);

		// Reduce
		int sum = IntStream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);
		System.out.println("Sum ::: " + sum);

		// min
		OptionalInt minimum = IntStream.of(1, 2, 3).min();
		System.out.println("Minimum ::: " + minimum);

		// max
		OptionalDouble max = Stream.of(1d, 2d, 3d).mapToDouble(Double::doubleValue).max();

		// A container object which may or may not contain a double value.If a
		// value is present, isPresent() will return true and getAsDouble() will
		// return the value.
		System.out.println("Maximum ::: " + max);

		// average
		OptionalDouble average = IntStream.of(1, 2, 3, 6, 12).average();
		System.out.println("Average ::: " + average);

		// Collect
		System.out.println("Collect ::: ");
		Set<String> stringSet = Stream.of("some", "one", "some", "one").collect(Collectors.toSet());
		System.out.println(stringSet);
		// Example
		Stream.of("some", "one", "some", "one").forEach(p -> System.out.println(p));

		// Lazy nature of streams
		System.out.println("Lazy nature of streams ::: ");
		Stream.iterate(0, n -> n + 2) // Source
				.peek(num -> System.out.println("Peeked at:" + num)) // Intermediate
																		// Operation
				.limit(5) // Intermediate Operation -- This optimization is
							// technically named as Short-Circuiting!
				.forEach(System.out::println); // Terminal Operation
	}

}
