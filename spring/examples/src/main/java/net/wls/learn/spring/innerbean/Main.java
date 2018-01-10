package net.wls.learn.spring.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-innerbean.xml");

        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.spellCheck();

        TextEditor textEditor2 = (TextEditor) context.getBean("textEditor2");
        textEditor2.spellCheck();
    }
}
