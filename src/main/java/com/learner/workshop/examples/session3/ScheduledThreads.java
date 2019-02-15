package com.learner.workshop.examples.session3;

/*
 * @Author Debu Paul
 */

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author manojgovindaraj
 *
 */
public class ScheduledThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		System.out.println("Main Thread Starting Time: " + new Date());
		Runnable task = () -> {
			System.out.println("\n Entering Thread: " + new Date());
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\n Exiting Thread: " + new Date());
		};

		ScheduledFuture<?> future = executor.schedule(task, 5, TimeUnit.SECONDS);

		long remainingDelay = future.getDelay(TimeUnit.SECONDS);
		System.out.printf("\n Remaining Delay: %s seconds", remainingDelay);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		remainingDelay = future.getDelay(TimeUnit.SECONDS);
		System.out.printf("\n Remaining Delay after sleep: %s seconds", remainingDelay);

		// executor.scheduleAtFixedRate(task, 3, 5,
		// TimeUnit.SECONDS);

		// executor.scheduleWithFixedDelay(task, 3, 5,
		// TimeUnit.SECONDS);

	}

}
