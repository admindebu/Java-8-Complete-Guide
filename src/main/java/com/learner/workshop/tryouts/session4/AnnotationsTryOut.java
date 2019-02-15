/**
 * 
 */
package com.learner.workshop.tryouts.session4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * @Author Debu Paul
 */

@interface Game {
	String name();

	String day();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Games {
	Game[] value();
}

// TODO:: Replace the following annotation with repeatable annotation

@Games({ @Game(name = "Cricket", day = "Sunday"), @Game(name = "Hockey", day = "Friday"),
		@Game(name = "Football", day = "Saturday") })
public class AnnotationsTryOut {

	public static void main(String[] args) {
		Games games = AnnotationsTryOut.class.getAnnotation(Games.class);
		for (Game game : games.value()) {
			System.out.println("Game: " + game.name() + "; Day: " + game.day());
		}
	}

}
