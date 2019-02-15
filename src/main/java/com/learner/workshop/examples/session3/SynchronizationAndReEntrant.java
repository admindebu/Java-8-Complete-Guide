package com.learner.workshop.examples.session3;

/*
 * @Author Debu Paul
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author manojgovindaraj
 *
 */
public class SynchronizationAndReEntrant {

	ReentrantLock lock = new ReentrantLock();

	int count = 0;

	void incrementSynchronized() {
		synchronized (this) {
			count = count + 1;
		}
	}

	void testSynchronization() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000).forEach(i -> executor.submit(this::incrementSynchronized));
		stop(executor);
		System.out.println(count);
	}

	void incrementReEntrant() {
		lock.lock();
		try {
			count = count + 1;
		} finally {
			lock.unlock();
		}
	}

	void testReEntrant() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000).forEach(i -> executor.submit(this::incrementReEntrant));
		stop(executor);
		System.out.println(count);
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
			SynchronizationAndReEntrant synchronization = new SynchronizationAndReEntrant();
			synchronization.testSynchronization();
			// synchronization.testReEntrant();
		}
	}

}
