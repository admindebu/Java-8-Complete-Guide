package com.learner.workshop.examples.session2.stream;

/*
 * @Author Debu Paul
 */

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates how stream order matters
 */
public class StreamOrder {

	private long counter;

	private void wasCalled() {
		counter++;
	}

	public static void main(String[] args) {

		List<String> list = Arrays.asList("abc1", "abc2", "abc3");

		StreamOrder obj = new StreamOrder();
		obj.counter = 0;

		long size = list.stream().map(element -> {
			obj.wasCalled();
			return element.substring(0, 3);
		}).skip(2).count();

		System.out.println(obj.counter);

		System.out.println(size);

		obj.counter = 0;
		size = list.stream().skip(2).map(element -> {
			obj.wasCalled();
			return element.substring(0, 3);
		}).count();

		System.out.println(obj.counter);

		System.out.println(size);

	}

}
