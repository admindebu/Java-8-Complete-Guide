package com.learner.workshop.examples.session2.stream;

/*
 * @Author Debu Paul
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demonstrates parallel stream
 */
public class ParallelStream {

	public static void main(String... args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		list.parallelStream().forEach(System.out::println);

		Map<String, String> wordCounts = new HashMap<>();

		wordCounts.put("usa", "U");
		wordCounts.put("jobs", "J");
		wordCounts.put("software", "S");
		wordCounts.put("technology", "T");
		wordCounts.put("opportunity", "O");

		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		System.out.println("===================================");

		myList.stream().filter(p -> p.startsWith("a")).map(String::toUpperCase).sorted().forEach(System.out::println);

		// Convert Map to Stream
		// Stream<Map.Entry<String, String>> stream = mapToStream(wordCounts);
	}
}
