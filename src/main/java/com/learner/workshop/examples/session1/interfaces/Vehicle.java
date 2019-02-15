package com.learner.workshop.examples.session1.interfaces;

/*
 * @Author Debu Paul
 */

public class Vehicle implements Fly, Transform {
	/*
	 * Understand the Use case scenarios. If I add new method in the Fly or
	 * Transform, I have to provide the implementation in this class as well, So
	 * no backward compatibility
	 */
	@Override
	public void fly() {
		System.out.println("Inside Vehicle :: I can Fly!!");
	}

	@Override
	public void transform() {
		System.out.println("Inside Vehicle :: I can Transform!!");
	}

	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.fly();
		vehicle.transform();

		// Calling default method of Vehcle interface
		vehicle.printSpecs();

		/*
		 * either Vehicle.notfly(); or (object) vehicle.notfly(); -> can't use ,
		 * beacuse notFly() is static member of Fly interface
		 */
		// Right approach is below -> Calling static method of Fly Interface
		Fly.notFly();

	}
}
