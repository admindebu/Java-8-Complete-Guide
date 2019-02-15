package com.learner.workshop.examples.session1.funtional_interface;


/*
 * @Author Debu Paul
 */


@FunctionalInterface
public interface Calculator {

    int calculate(int x);

    // We can't add more than one abstract method as it is annotated with @FunctionalInterface

    // void stdDeviation();

    // We can add any no. of static and default method
    default double sqrt(int a) {
        return Math.sqrt(positive(a));
    }

    // static method ( can't be overriden in implementation class)
    static int positive(int a) {
        return a > 0 ? a : 0;
    }
}
