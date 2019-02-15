package com.learner.workshop.examples.session3;

/*
 * @Author Debu Paul
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author manojgovindaraj
 *
 */
public class ExecutorSubmitAndTimeout {

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			Future future = executor.submit(() -> {
				String threadName = Thread.currentThread().getName();
				System.out.println("Entering Thread " + threadName);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Exiting Thread " + threadName);
				return "Done!";
			});

			System.out.println("Is Completed? " + future.isDone());

			Object result = future.get();

			// Object result = future.get(1, TimeUnit.SECONDS);
			System.out.println("Is Completed? " + future.isDone());
			System.out.print("Result: " + result);

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}

}
