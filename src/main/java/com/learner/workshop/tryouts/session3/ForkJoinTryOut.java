package com.learner.workshop.tryouts.session3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/*
 * @Author Debu Paul
 */

public class ForkJoinTryOut {
	/**
	 * Recursive Action
	 * <p>
	 * Make below RecursiveAction to accept number. If the number is more than
	 * 4, split the task into two by dividing the number by 2 and make subtasks
	 * to recurse again else print the number.
	 */

	private static class RecurActionSample extends RecursiveAction {
		int number;

		RecurActionSample(int number) {
			this.number = number;
		}

		@Override
		protected void compute() {

		}
	}

	/**
	 * Recursive Task
	 * <p>
	 * Make below RecursiveTask to accept an integer. If the number is greater
	 * than 10, divide the number by 2 and make subtasks and recurse again else
	 * multiply the number by 5.
	 */

	private static class RecurTaskSample extends RecursiveTask<Integer> {
		int number;

		RecurTaskSample(int number) {
			this.number = number;
		}

		@Override
		protected Integer compute() {
			return null;
		}
	}

	public static void main(String[] args) {
		ForkJoinPool testRecursiveAction = new ForkJoinPool(5);
		testRecursiveAction.invoke(new RecurActionSample(64));

		testRecursiveAction.shutdown();

		ForkJoinPool testRecursiveTask = new ForkJoinPool(5);
		Integer result = testRecursiveTask.invoke(new RecurTaskSample(20));

		System.out.println("Merged Result = " + result);
	}
}
