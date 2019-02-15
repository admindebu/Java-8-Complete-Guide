package com.learner.workshop.examples.session4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * @Author Debu Paul
 */

public class CollectorsExample {
	public static void main(String[] args) {
		List<Integer> integers = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

		String alphabets = Stream.of("abc", "def", "ghi").collect(Collectors.joining());

		System.out.println("alphabets = " + alphabets);

		List<String> list = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(k -> k, String::length));
		System.out.println("to map = " + map);

		Map<Boolean, List<Integer>> partition = integers.stream().collect(Collectors.partitioningBy(i -> i > 500));

		System.out.println("Greater than 500 = " + partition.get(true));
		System.out.println("Lesser than 500 = " + partition.get(false));

		Map<Integer, List<String>> sizeWise = Stream.of("abcd", "ef", "g", "hijklm")
				.collect(Collectors.groupingBy(String::length, Collectors.toList()));

		System.out.println("sizeWise = " + sizeWise);
	}
}
