package net.wls.learn.spring.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context-lifecycle.xml");
        ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");
        ExampleBean exampleBean2 = (ExampleBean) context.getBean("exampleBean2");
        context.registerShutdownHook();
    }
}
