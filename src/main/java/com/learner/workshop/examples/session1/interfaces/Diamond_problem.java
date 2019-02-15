package com.learner.workshop.examples.session1.interfaces;

/*
 * @Author Debu Paul
 */

public class Diamond_problem implements com.learner.workshop.examples.session1.interfaces.HasColor, Transform {

	// Providing Implementation of transform abstract method of Transform
	// Interface
	@Override
	public void transform() {
		System.out.println("Implementation of transform");
	}

	// Providing Implementation of getColor abstract method of HasColor
	// Interface
	@Override
	public String getColor() {
		return "RED";
	}

	/*
	 * if we not implement this method using super keyword we will get
	 * compilation error as both interface have this method
	 */
	@Override
	public void printSpecs() {

		com.learner.workshop.examples.session1.interfaces.HasColor.super.printSpecs();
		/*
		 * If we change the Interface name from HasColor to Transform, we will
		 * get different result
		 */
	}

	// In one shot both representation

	/*
	 * @Override public void printSpecs() {
	 *
	 * HasColor.super.printSpecs(); Transform.super.printSpecs();
	 *
	 * }
	 */
	public static void main(String[] args) {

		Diamond_problem dm = new Diamond_problem();
		dm.printSpecs();

	}

}
