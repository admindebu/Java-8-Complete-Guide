package com.learner.workshop.examples.session1.funtional_interface;


/*
 * @Author Debu Paul
 */


import java.util.function.Function;

public class TestFunction {
    public static void main(String[] args) {
        String name = "peter";
        //Get identity of the Function operator. Note : identity() is a static method.
        System.out.println(Function.identity().apply(name));

        Function operator = (a) -> "hello, " + a;

        // apply operation to a Function.
        System.out.println(operator.apply(name));


        // add addtional functional operator to the exisiting funtional operator.

        // define a funtion
        Function say_good_afternoon = new Function() {
            @Override
            public Object apply(Object o) {
                return "good afternoon " + o;
            }
        };
        //  function composition to the exisiting unary opeartor.
        System.out.println(operator.compose(say_good_afternoon).apply(name));

        //function composition to the exisiting unary opeartor with andThen .
        System.out.println(operator.andThen(new Function() {
            @Override
            public Object apply(Object o) {
                return o + " !";
            }
        }).apply(name));


    }
}
