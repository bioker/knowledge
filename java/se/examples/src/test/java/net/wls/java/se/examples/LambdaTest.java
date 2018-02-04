package net.wls.java.se.examples;

import org.junit.Test;

public class LambdaTest {

    @Test
    public void test() {
        MathOperation addition = (int a, int b) -> a + b;
        System.out.println(addition.operation(1, 2));

        GreetingService hiService = (String name) -> System.out.println("Hi " + name);
        GreetingService heyService = (String name) -> System.out.println("Hey " + name);

        hiService.greet("John");
        heyService.greet("Tom");
    }
}
