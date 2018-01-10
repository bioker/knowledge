package net.wls.learn.spring.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-collections.xml");

        JavaCollections javaCollections = (JavaCollections) context.getBean("javaCollections");
        javaCollections.getAddressesList();
        javaCollections.getAddressesMap();
        javaCollections.getAddressesSet();
        javaCollections.getAddressesProp();
    }
}
