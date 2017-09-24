package net.wls.jmx;

public class HelloMBeanImpl implements HelloMBean {

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
