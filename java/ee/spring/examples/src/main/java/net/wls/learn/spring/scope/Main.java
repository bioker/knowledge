package net.wls.learn.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-scope.xml");
        Greeting greeting1 = (Greeting) context.getBean("singleton-greeting");
        greeting1.sayHello();

        greeting1.setName("Peter");

        Greeting greeting2 = (Greeting) context.getBean("singleton-greeting");
        greeting2.sayHello();

        Greeting greeting3 = (Greeting) context.getBean("prototype-greeting");
        greeting3.sayHello();

        greeting3.setName("Peter");

        Greeting greeting4 = (Greeting) context.getBean("prototype-greeting");
        greeting4.sayHello();
    }
}
