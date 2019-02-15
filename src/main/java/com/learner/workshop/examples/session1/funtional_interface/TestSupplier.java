package com.learner.workshop.examples.session1.funtional_interface;

/*
 * @Author Debu Paul
 */

import java.util.function.Supplier;

public class TestSupplier {
	public static void main(String[] args) {
		// Supplier Interface return object does not accept any input.

		// Supplier interface with lambda exoression
		Supplier random = () -> (Math.random() * 1000);

		// get a random digit .
		System.out.println(random.get());

		// Supplier interface with anonymous .
		Supplier sayHello = new Supplier() {
			@Override
			public Object get() {
				return "hello";
			}
		};

		System.out.println(sayHello.get());

	}
}
