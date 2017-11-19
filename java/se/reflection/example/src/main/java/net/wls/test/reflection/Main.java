package net.wls.test.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) {
        Method[] methods = TestClass.class.getMethods();
        for (Method method : methods) {
            System.out.println("method:");
            System.out.println("name: " + method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("\tparameter:");
                System.out.println("\tname: " + parameter.getName());
                System.out.println("\ttype: " + parameter.getType());
            }
        }
    }
}
