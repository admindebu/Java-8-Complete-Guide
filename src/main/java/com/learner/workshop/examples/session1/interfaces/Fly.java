package com.learner.workshop.examples.session1.interfaces;

/*
 * @Author Debu Paul
 */

public interface Fly {
	void fly();

	// Implementation of static method

	static void notFly() {
		System.out.println("Inside Fly Interface :: static method :: Car can't fly !!!!");
	}

}
