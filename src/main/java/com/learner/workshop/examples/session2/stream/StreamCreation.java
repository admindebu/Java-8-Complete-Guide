package com.learner.workshop.examples.session2.stream;

/*
 * @Author Debu Paul
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Various methods of stream creation
 */
public class StreamCreation {

	public static void main(String[] args) {
		// Create an Empty Stream :

		Stream<String> streamEmpty = Stream.empty();

		// Stream can also be created of any type of Collection (Collection,
		// List, Set):
		Collection<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();

		// Array can also be a source of a Stream:
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		String[] arr = new String[] { "a", "b", "c" };
		Stream<String> streamOfArrayFull = Arrays.stream(arr);

		// Stream Pipeline:
		Stream<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(1);
		Stream<String> twiceModifiedStream = onceModifiedStream.skip(1).map(element -> element.substring(0, 3));

		// When builder is used the desired type should be additionally
		// specified in the right part of the statement, otherwise the build()
		// method will create an instance of the Stream<Object>:

		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
		streamBuilder.forEach(k -> System.out.println(k));

		// Infinite Streams

		/*
		 * 1. Stream.generate()
		 * 
		 * The generate() method accepts a Supplier<T> for element generation.
		 * As the resulting stream is infinite, developer should specify the
		 * desired size or the generate() method will work until it reaches the
		 * memory limit:
		 */
		Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);

		/*
		 * 2. Stream.iterate()
		 * 
		 * Another way of creating an infinite stream is by using the iterate()
		 * method:
		 */
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

	}
}
