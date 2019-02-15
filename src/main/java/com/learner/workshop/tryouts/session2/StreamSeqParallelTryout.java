package com.learner.workshop.tryouts.session2;

/*
 * @Author Debu Paul
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * COmparing sequential and parallel streams
 */
public class StreamSeqParallelTryout {

	public static final int MAX = 1000000;

	public static void sortSequential() {
		List<String> values = new ArrayList<>(MAX);
		for (int i = 0; i < MAX; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		// Do sequential sort, note the time before and after execution and
		// update millis

		long millis = 0;
		System.out.println(String.format("sequential sort took: %d ms", millis));
	}

	public static void sortParallel() {
		List<String> values = new ArrayList<>(MAX);
		for (int i = 0; i < MAX; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		// Do parallel sort, note the time before and after execution and update
		// millis
		long millis = 0;
		System.out.println(String.format("parallel sort took: %d ms", millis));
	}

	public static void main(String[] args) {
		sortSequential();
		sortParallel();
	}
}
