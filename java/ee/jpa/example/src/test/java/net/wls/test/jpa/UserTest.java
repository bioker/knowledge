package net.wls.test.jpa;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class UserTest {

    private static EntityManager entityManager;

    @BeforeClass
    public static void init() {
        entityManager = JPAHelper.getEntityManager();
    }

    private long id;

    @Test
    public void test1() {
        User user = new User();
        user.setName("Kate");
        user.setEmail("kate@gmail.com");

        try {
            entityManager.getTransaction().begin();
            user = entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

        id = user.getId();
        System.out.println(id);

        User storedUser;
        storedUser = entityManager.find(User.class, id);
        System.out.println(storedUser.getName());
        System.out.println(storedUser.getEmail());
    }

    @Test
    public void queryTest() {

        User user = new User();
        user.setName("Kate");
        user.setEmail("kate@gmail.com");

        User user2 = new User();
        user2.setName("Viktor");
        user2.setEmail("viktor@gmail.com");

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.merge(user2);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

        List users = entityManager.createQuery("SELECT user FROM User user")
                .getResultList();
        System.out.println("Simple query");
        System.out.println("count of founded users: " + users.size());
        for (Object foundedUser : users) {
            System.out.println("user id: " + ((User) foundedUser).getId());
            System.out.println("user name: " + ((User) foundedUser).getName());
            System.out.println("user email: " + ((User) foundedUser).getEmail());
        }

        System.out.println("------------------------------------------------------");

        users = entityManager.createNamedQuery("User.findAll")
                .getResultList();
        System.out.println("Named query find all");
        System.out.println("count of founded users: " + users.size());
        for (Object foundedUser : users) {
            System.out.println("user id: " + ((User) foundedUser).getId());
            System.out.println("user name: " + ((User) foundedUser).getName());
            System.out.println("user email: " + ((User) foundedUser).getEmail());
        }

        System.out.println("------------------------------------------------------");

        users = entityManager.createNamedQuery("User.findByName")
                .setParameter("userName", "Viktor")
                .getResultList();
        System.out.println("Named query find by name 'Viktor'");
        System.out.println("count of founded users: " + users.size());
        for (Object foundedUser : users) {
            System.out.println("user id: " + ((User) foundedUser).getId());
            System.out.println("user name: " + ((User) foundedUser).getName());
            System.out.println("user email: " + ((User) foundedUser).getEmail());
        }

        System.out.println("------------------------------------------------------");

        users = entityManager.createNamedQuery("User.findByEmail")
                .setParameter("userEmail", "kate@gmail.com")
                .getResultList();
        System.out.println("Named query find by email 'kate@gmail.com'");
        System.out.println("count of founded users: " + users.size());
        for (Object foundedUser : users) {
            System.out.println("user id: " + ((User) foundedUser).getId());
            System.out.println("user name: " + ((User) foundedUser).getName());
            System.out.println("user email: " + ((User) foundedUser).getEmail());
        }

        System.out.println("------------------------------------------------------");

    }

}
