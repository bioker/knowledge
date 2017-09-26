package net.wls.jmx;

public class Calculator implements CalculatorMBean {

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
