package net.wls.jmx;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class SimpleAgent {

    public static void main(String[] args) {
        SimpleAgent simpleAgent = new SimpleAgent();
        System.out.println("SimpleAgent is running");
        simpleAgent.waitForEnterPressed();
    }

    private MBeanServer mbs = null;

    public SimpleAgent() {
        mbs = ManagementFactory.getPlatformMBeanServer();

        HelloMBean helloMBean = new HelloMBeanImpl();
        ObjectName helloMBeanName;

        try {
            helloMBeanName = new ObjectName("SimpleAgent:name=helloMBean");
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
