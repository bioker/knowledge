package net.wls.learn.spring.lifecycle;

public class ExampleBean {

    public void init() {
        System.out.println("ExampleBean init");
    }

    public void defaultInit() {
        System.out.println("ExampleBean default init");
    }

    public void destroy() {
        System.out.println("ExampleBean destroy");
    }

    public void defaultDestroy() {
        System.out.println("ExampleBean default destroy");
    }
}
