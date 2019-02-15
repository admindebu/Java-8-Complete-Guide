package com.learner.workshop.examples.session1.interfaces;

/*
 * @Author Debu Paul
 */

public interface Transform {
	void transform();

	// Implementation of default Method
	default void printSpecs() {
		System.out.println("Inside Tranform Interface :: default method :: Transform Specification");
	}
}
