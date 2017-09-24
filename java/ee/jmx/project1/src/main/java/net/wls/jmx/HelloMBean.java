package net.wls.jmx;

public interface HelloMBean {
    void setName(String name);

    String getName();

    void sayHello();
}
