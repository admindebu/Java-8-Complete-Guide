package com.learner.workshop.examples.session1.funtional_interface;


/*
 * @Author Debu Paul
 */


public class ComputeCalculator {

    public static void main(String args[]) {
        int a = 5;

        // define the calculate method Before Java 8
        Calculator s = new Calculator() {
            @Override
            public int calculate(int x) {
                return x * x * 100;
            }
        };
        // parameter passed and return type must be
        // same as defined in the prototype
        int ans = s.calculate(a);
        System.out.println(ans);

        // with lambda expression ( After Java 8) to define the calculate method
        Calculator s2 = (x) -> (x * x * x);
        // parameter passed and return type must be
        // same as defined in the prototype
        int cube = s2.calculate(a);
        System.out.println(cube);

    }

}
