package com.learner.workshop.examples.session1.lambda;

/*
 * @Author Debu Paul
 */

import java.util.function.*;

public class Lambda {
	public static void main(String[] args) {

		// define a calculator function
		Calculator cal = new Calculator() {
			@Override
			public int calculate(int x) {
				return x * 100;
			}
		};
		System.out.println(cal.calculate(2));

		// with lambda expression
		Calculator cal2 = (a) -> {
			return a * 100;
		};
		System.out.println(cal2.calculate(3));

		// can simply further the above lambda expression
		Calculator cal3 = (a) -> a * 100;
		System.out.println(cal3.calculate(4));

		// function with no parameters
		Supplier random = new Supplier() {
			@Override
			public Object get() {
				return Math.random();
			}
		};
		System.out.println(random.get());

		// lambda expression for null parameter
		Supplier random2 = () -> Math.random();
		System.out.println(random2.get());

		// function with no return
		Consumer consume = new Consumer() {
			@Override
			public void accept(Object o) {
				System.out.println("Hello");
			}
		};

		// lambda expression for no return object
		Consumer consume2 = (a) -> System.out.println(a);
		consume2.accept("hello");
	}

}
