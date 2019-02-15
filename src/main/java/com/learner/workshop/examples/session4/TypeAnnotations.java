package com.learner.workshop.examples.session4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
 * @Author Debu Paul
 */

public class TypeAnnotations {
	@Target(ElementType.TYPE_USE)
	private @interface NonNull {
		// code ...
	}

	public static void main(String[] args) {
		@NonNull
		String a = "";
	}

	private <@NonNull T> void method(@NonNull T input) {
		String a = null;

		Object b = "abc";

		a = (@NonNull String) b;
	}

	private class MyClass<@NonNull T> {

	}
}
