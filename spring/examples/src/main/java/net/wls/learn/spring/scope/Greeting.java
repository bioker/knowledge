package net.wls.learn.spring.scope;

public class Greeting {

    private String name;

    public void sayHello() {
        System.out.println("Hello, " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
