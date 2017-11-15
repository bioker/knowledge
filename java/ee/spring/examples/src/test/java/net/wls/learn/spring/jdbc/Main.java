package net.wls.learn.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    @Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        List<User> users = userDAO.findAll();
        for (User user : users) {
            System.out.println("user:");
            System.out.println("\tid: " + user.getId());
            System.out.println("\tname: " + user.getName());
            System.out.println("\temail: " + user.getEmail());
        }
        User user = userDAO.findByName("alex");
        System.out.println("Alex:");
        System.out.println("\tid: " + user.getId());
        System.out.println("\tname: " + user.getName());
        System.out.println("\temail: " + user.getEmail());
    }

}
