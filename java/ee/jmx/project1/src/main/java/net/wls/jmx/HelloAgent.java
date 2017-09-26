package net.wls.jmx;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class HelloAgent {

    public static void main(String[] args) {
        HelloAgent helloAgent = new HelloAgent();
        System.out.println("HelloAgent is running");
        helloAgent.waitForEnterPressed();
    }

    private MBeanServer mbs = null;

    public HelloAgent() {
        mbs = ManagementFactory.getPlatformMBeanServer();

        HelloMBean helloMBean = new Hello();
        ObjectName helloMBeanName;

        try {
            helloMBeanName = new ObjectName("HelloAgent:name=helloMBean");
            mbs.registerMBean(helloMBean, helloMBeanName);
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
