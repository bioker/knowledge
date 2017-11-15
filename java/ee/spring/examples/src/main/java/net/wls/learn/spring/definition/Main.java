package net.wls.learn.spring.definition;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-definition.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        HelloRussia helloRussia = (HelloRussia) context.getBean("helloRussia");

        System.out.println(helloWorld.getMessage1());
        System.out.println(helloWorld.getMessage2());

        System.out.println(helloRussia.getMessage1());
        System.out.println("this value was inherited:");
        System.out.println(helloRussia.getMessage2());
        System.out.println(helloRussia.getMessage3());

        // this code will throw exception because bean definition is abstract
        //TextEditor helloWorldPrototype = (TextEditor) context.getBean("helloWorldPrototype");

        HelloWorld helloWorldInstance = (HelloWorld) context.getBean("helloWorldInstance");

        System.out.println("this values was inherited:");
        System.out.println(helloWorldInstance.getMessage1());
        System.out.println(helloWorldInstance.getMessage2());
    }
}
