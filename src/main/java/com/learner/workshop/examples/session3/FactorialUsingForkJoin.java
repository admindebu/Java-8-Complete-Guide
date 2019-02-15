
package com.learner.workshop.examples.session3;

/*
 * @Author Debu Paul
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * @author manojgovindaraj
 *
 */
public class FactorialUsingForkJoin extends RecursiveTask<BigInteger> {
	private static final long serialVersionUID = -45914392886125848L;
	private int start = 1;
	private int n;
	private static final int THRESHOLD = 20;

	public FactorialUsingForkJoin(int n) {
		this.n = n;
	}

	public FactorialUsingForkJoin(int start, int n) {
		this.start = start;
		this.n = n;
	}

	@Override
	protected BigInteger compute() {
		if ((n - start) >= THRESHOLD) {
			final Collection<FactorialUsingForkJoin> subtasks = createSubtasks();
			System.out.println("Total No. Of Subtasks: " + subtasks.size());
			return ForkJoinTask.invokeAll(subtasks).stream().map(ForkJoinTask::join).reduce(BigInteger.ONE,
					BigInteger::multiply);
		} else {
			return calculate(start, n);
		}
	}

	private Collection<FactorialUsingForkJoin> createSubtasks() {
		List<FactorialUsingForkJoin> dividedTasks = new ArrayList<>();
		int mid = (start + n) / 2;
		dividedTasks.add(new FactorialUsingForkJoin(start, mid));
		dividedTasks.add(new FactorialUsingForkJoin(mid + 1, n));
		System.out.println("Created subtask of size: " + dividedTasks.size());
		return dividedTasks;
	}

	private BigInteger calculate(int start, int n) {
		return IntStream.rangeClosed(start, n).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,
				BigInteger::multiply);
	}

	public static class Main {
		public static void main(String[] args) {
			ForkJoinPool pool = ForkJoinPool.commonPool();
			BigInteger result = pool.invoke(new FactorialUsingForkJoin(100));
			System.out.println("Factorial Result: " + result);
		}
	}
}