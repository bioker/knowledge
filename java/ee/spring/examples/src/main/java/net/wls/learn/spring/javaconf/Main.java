package net.wls.learn.spring.javaconf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);

        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        helloWorld.setMessage("Hello World!");

        System.out.println(helloWorld.getMessage());

        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext();
        context2.register(HelloWorldConfig.class);
        context2.refresh();

        HelloWorld helloWorld2 = context2.getBean(HelloWorld.class);
        helloWorld2.setMessage("Hello World!");

        System.out.println(helloWorld2.getMessage());

        ApplicationContext context3 = new AnnotationConfigApplicationContext(TextEditorConfig.class);
        TextEditor textEditor = context3.getBean(TextEditor.class);
        textEditor.spellCheck();

        ApplicationContext context4 = new AnnotationConfigApplicationContext(ConfigB.class);
        A a = context4.getBean(A.class);
        B b = context4.getBean(B.class);
        a.hello();
        b.hello();

        AnnotationConfigApplicationContext context5 = new AnnotationConfigApplicationContext(FooConfig.class);
        context5.getBean(Foo.class);
        context5.close();
    }
}
