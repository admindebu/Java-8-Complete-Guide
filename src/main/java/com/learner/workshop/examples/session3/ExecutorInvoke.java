
package com.learner.workshop.examples.session3;

/*
 * @Author Debu Paul
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author manojgovindaraj
 *
 */
public class ExecutorInvoke {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		List<Callable<String>> callables = new ArrayList<>();
		callables.add(callable("Task 1", 2));
		callables.add(callable("Task 2", 1));
		callables.add(callable("Task 3", 3));

		try {
			System.out.println("Invoke All");
			List<Future<String>> results = executor.invokeAll(callables);
			results.forEach(future -> {
				try {
					System.out.println(future.get());
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});

			System.out.println("\nInvoke Any");
			String result = executor.invokeAny(callables);
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}

	}

	private static Callable<String> callable(String result, long sleepSeconds) {
		return () -> {
			TimeUnit.SECONDS.sleep(sleepSeconds);
			return result;
		};
	}

}
