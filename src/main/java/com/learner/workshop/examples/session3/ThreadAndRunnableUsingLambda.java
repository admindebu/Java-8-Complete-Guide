/**
 * 
 */
package com.learner.workshop.examples.session3;

/*
 * @Author Debu Paul
 */

public class ThreadAndRunnableUsingLambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Entering Thread: " + threadName);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Exiting Thread: " + threadName);
		};

		Thread thread = new Thread(task);
		thread.start();

		System.out.println("Done!");

	}

}
