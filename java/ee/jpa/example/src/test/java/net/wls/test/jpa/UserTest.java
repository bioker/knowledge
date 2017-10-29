package net.wls.test.jpa;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;

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

}
