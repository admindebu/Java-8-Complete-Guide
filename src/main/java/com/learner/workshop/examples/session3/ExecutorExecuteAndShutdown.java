
package com.learner.workshop.examples.session3;

/*
 * @Author Debu Paul
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author manojgovindaraj
 *
 */
public class ExecutorExecuteAndShutdown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			executor.execute(() -> {
				String threadName = Thread.currentThread().getName();
				System.out.println("Entering Thread " + threadName);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Exiting Thread " + threadName);
			});
		} finally {
			// executor.shutdown();
		}
	}

}
