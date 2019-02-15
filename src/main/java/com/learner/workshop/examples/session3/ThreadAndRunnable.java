/**
 * 
 */
package com.learner.workshop.examples.session3;

/*
 * @Author Debu Paul
 */

public class ThreadAndRunnable extends Thread {

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("Entering Thread " + threadName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exiting Thread " + threadName);
	}

	public static class Main {

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			int numberOfThreads = 10; // Number of threads
			for (int i = 0; i < numberOfThreads; i++) {
				ThreadAndRunnable thread = new ThreadAndRunnable();
				// Thread thread = new Thread(new ThreadAndRunnable());

				// thread.run();
				thread.start();
			}
		}
	}

}
