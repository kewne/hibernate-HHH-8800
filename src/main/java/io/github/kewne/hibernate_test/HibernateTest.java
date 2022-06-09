package io.github.kewne.hibernate_test;

import javax.persistence.Persistence;

public class HibernateTest {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("io.github.kewne.hibernate_test");
        var entityManager = entityManagerFactory.createEntityManager();
        var transaction = entityManager.getTransaction();

        var parent = new Parent();

        transaction.begin();


        entityManager.persist(parent);

        entityManager.flush();
        transaction.commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();

        transaction.begin();
        parent = entityManager.find(Parent.class, 1L);

        var peter = new Child();
        entityManager.persist(peter);

        var mark = new Child();
        entityManager.persist(mark);

        parent.addChild("Peter", peter);
        parent.addChild("Mark", mark);
        parent = entityManager.merge(parent);
        transaction.commit();
    }
}
