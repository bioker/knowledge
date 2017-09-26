package net.wls.jmx;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class CalculatorAgent {

    public static void main(String[] args) {
        CalculatorAgent helloAgent = new CalculatorAgent();
        System.out.println("CalculatorAgent is running");
        helloAgent.waitForEnterPressed();
    }

    private MBeanServer mbs = null;

    public CalculatorAgent() {
        mbs = ManagementFactory.getPlatformMBeanServer();

        CalculatorMBean calculatorMBean = new Calculator();
        ObjectName calculatorMBeanName;

        try {
            calculatorMBeanName = new ObjectName("CalculatorAgent:name=calculatorMBean");
            mbs.registerMBean(calculatorMBean, calculatorMBeanName);
        } catch (MalformedObjectNameException |
                NotCompliantMBeanException |
                InstanceAlreadyExistsException |
                MBeanRegistrationException e) {
            e.printStackTrace();
        }
    }

    private void waitForEnterPressed() {
        try {
            System.out.println("Press enter to continue...");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
