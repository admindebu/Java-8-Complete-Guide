package com.learner.workshop.examples.session4;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * @Author Debu Paul
 */

public class RepeatingAnnotations {
	@Repeatable(Colors.class)
	@interface Color {
		String value();
	}

	@Retention(RetentionPolicy.RUNTIME)
	@interface Colors {
		Color[] value();
	}

	@Color("red")
	@Color("blue")
	private static class Shirt {
		public static void main(String[] args) {
			Color[] colors = Shirt.class.getAnnotationsByType(Color.class);

			for (Color color : colors) {
				System.out.println("color = " + color.value());
			}
		}
	}
}
