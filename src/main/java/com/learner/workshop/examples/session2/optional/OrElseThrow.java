package com.learner.workshop.examples.session2.collection.optional;

import java.util.Optional;

/*
 * @Author Debu Paul
 */

public class OrElseThrow {

	public static void main(String[] args) {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);

	}

}
