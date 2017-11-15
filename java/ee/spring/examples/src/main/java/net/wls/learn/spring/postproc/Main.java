package net.wls.learn.spring.postproc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context-postproc.xml");
        ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");
        context.registerShutdownHook();
    }
}
