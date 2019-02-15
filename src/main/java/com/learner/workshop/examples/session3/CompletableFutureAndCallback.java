package com.learner.workshop.examples.session3;

/*
 * @Author Debu Paul
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author manojgovindaraj
 *
 */
public class CompletableFutureAndCallback {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Entering Thread " + threadName);
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Exiting Thread " + threadName);
			return "Done!";
		});
		System.out.println("Aysnc Call Invoked Successfully!");
		CompletableFuture<String> futureOfCallback = future.thenApply(result -> "Callback " + result);
		try {
			System.out.println(futureOfCallback.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
