package com.learner.workshop.tryouts.session2;

/*
 * @Author Debu Paul
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Tryouts to experiment collections changes Advantages:
 * 
 * Thread-safe Readable. Default Sorting in ascending order.
 * 
 */
public class CollectionChangesTryout {

	public static void main(String[] args) {

		// Sorting by key and value
		Map<String, String> map = new HashMap<>();
		map.put("imaginea", "c");
		map.put("pramati", "b");
		map.put("wavemaker", "z");
		map.put("socialtwist", "z");
		map.put("thumbsignin", "z");

		// Sort map by key, iterate the map using forEach and print
		System.out.println("Sorting By Key ::: ");

		// Sort map by value, iterate the map using forEach and print
		System.out.println("Sorting By Value ::: ");

		// Get the value of key key "AJG" from the above map, if there is no
		// mapping, return "invalid"
		System.out.println("Value for AJG in map ::: ");

		// Replace value of key 'imaginea' with 'i' only if it is already mapped
		// to 'c'
		System.out.println("Value for imaginea ::: ");

		// Add key-pramati, value-p to the map. Do not override if the key
		// already exists
		System.out.println("Value for pramati ::: ");

		// Concatenate value of key "socialtwist" with "-hello"
		System.out.println("Value for socialtwist ::: ");

	}

}
