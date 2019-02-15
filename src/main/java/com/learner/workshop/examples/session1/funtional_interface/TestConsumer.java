package com.learner.workshop.examples.session1.funtional_interface;

/*
 * @Author Debu Paul
 */

import java.util.function.Consumer;

public class TestConsumer {

	public static void main(String[] args) {
		// Consumer Interface accepts Input only no return type.

		// Consumer Interface with anaymous
		Consumer a = new Consumer() {
			@Override
			public void accept(Object o) {
				System.out.println("hello " + o);
			}
		};

		a.accept("peter");

		// Consumer Interface with lambda
		Consumer b = (name) -> System.out.println("hello " + name);

		b.accept("Steve");
	}

}
