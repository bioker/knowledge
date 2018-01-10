package net.wls.learn.spring.hello;

import net.wls.learn.spring.hello.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-hello.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        System.out.println(helloWorld.getMessage());
    }
}
