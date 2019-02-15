package com.learner.workshop.examples.session4;

import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * @Author Debu Paul
 */

public class Spliterators {
	private static class Worker implements Runnable {
		private final String worker;
		private final Spliterator<Integer> spliterator;

		private Worker(String worker, Spliterator<Integer> spliterator) {
			this.worker = worker;
			this.spliterator = spliterator;
		}

		@Override
		public void run() {
			spliterator.forEachRemaining(i -> System.out.println(worker + " " + i));
		}
	}

	public static void main(String[] args) {
		List<Integer> list = IntStream.range(1, 1001).boxed().collect(Collectors.toList());

		Spliterator<Integer> s1 = list.spliterator();

		Spliterator<Integer> s2 = s1.trySplit();

		System.out.println("s1 size = " + s1.estimateSize());
		System.out.println("s2 size = " + s2.estimateSize());

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		try {
			executorService.submit(new Worker("W1", s1));
			executorService.submit(new Worker("W2", s2));
		} finally {
			executorService.shutdown();
		}
	}
}
