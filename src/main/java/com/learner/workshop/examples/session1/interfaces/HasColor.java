package com.learner.workshop.examples.session1.interfaces;

/*
 * @Author Debu Paul
 */

public interface HasColor {

	public String getColor();

	// Implementation of default Method -> creating Diamond problem
	default void printSpecs() {
		System.out.println("Inside HasColor Interface :: default method :: HasColor Specification");
	}

}
