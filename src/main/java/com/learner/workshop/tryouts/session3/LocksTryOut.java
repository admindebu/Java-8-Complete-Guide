package com.learner.workshop.tryouts.session3;

/*
 * @Author Debu Paul
 */

public class LocksTryOut {
	private static class Resource {
		void doWork(String threadName) {
			System.out.println(threadName + " work complete...!!!");
		}
	}

	/**
	 * Create a 5 Runnable instances sharing the same Resource and protect the
	 * execution of Resource doWork() method using the same. Achieve it using
	 * Reentrant lock.
	 */

	private static class Worker implements Runnable {
		private String threadName;
		private Resource resource;

		@Override
		public void run() {
			try {
				resource.doWork(threadName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
	}
}
