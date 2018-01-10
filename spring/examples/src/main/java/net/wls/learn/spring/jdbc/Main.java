package net.wls.learn.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-context-jdbc.xml");
        PersonDAO personDAO = (PersonDAO) context.getBean("personDAO");
        int status = personDAO.savePerson(new Person(1, "Viktor"));
        System.out.println("status: " + status);

        ParametrizedPersonDao parametrizedPersonDao =
                (ParametrizedPersonDao) context.getBean("parametrizedPersonDAO");
        Boolean result = parametrizedPersonDao.savePerson(new Person(2, "Steve"));
        System.out.println("result: " + result);

        ResultPersonDao resultPersonDao =
                (ResultPersonDao) context.getBean("resultPersonDAO");
        List<Person> personList = resultPersonDao.getAllPersons();
        for (Person person : personList) {
            System.out.println("person: " + person);
        }

        RowPersonDao rowPersonDao =
                (RowPersonDao) context.getBean("rowPersonDAO");
        List<Person> personList2 = rowPersonDao.getAllPersons();
        for (Person person : personList2) {
            System.out.println("person2: " + person);
        }

        NamedPersonDao namedPersonDao =
                (NamedPersonDao) context.getBean("namedPersonDAO");
        namedPersonDao.savePerson(new Person(3, "Lois"));
    }
}
