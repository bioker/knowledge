package net.wls.jmx;

import javax.management.MXBean;

@MXBean
public class Hello implements HelloMBean {

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello " + name + "!");
    }
}
