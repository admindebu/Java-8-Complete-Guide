package com.learner.workshop.examples.session3;

/*
 * @Author Debu Paul
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author manojgovindaraj
 *
 */
public class Semaphores {

	public void testSemaphore() {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Semaphore semaphore = new Semaphore(5);
		Runnable longRunningTask = () -> {
			try {
				semaphore.acquire();
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " is sleeping....");
				TimeUnit.SECONDS.sleep(5);
				semaphore.release();
				System.out.println(threadName + " is released....");
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		};

		IntStream.range(0, 10).forEach(i -> executor.submit(longRunningTask));

		stop(executor);
	}

	public static void stop(ExecutorService executor) {
		try {
			executor.shutdown();
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("Termination interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("Killing non-finished tasks");
			}
			executor.shutdownNow();
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Semaphores semaphores = new Semaphores();
			semaphores.testSemaphore();
		}
	}

}
