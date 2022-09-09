package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manytomany.Publication;
import com.springsimplespasos.hibernate.entidades.manytomany.User;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;

public class ManyToManyMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();

        User admin = new User(1, "Admin");
        User raul = new User(2, "Raul");

        Publication hello = new Publication(1, "Hello");
        Publication goodbye = new Publication(2, "Goodbye");
        Publication pack = new Publication(3, "Share the pack");
        Publication love = new Publication(4, "I love you");

        admin.setPublications(Arrays.asList(hello, goodbye));
        raul.setPublications(Arrays.asList(hello,pack,love));

        session.beginTransaction();

//        session.saveOrUpdate(admin);
//        session.saveOrUpdate(raul);
//        session.saveOrUpdate(hello);
//        session.saveOrUpdate(goodbye);
//        session.saveOrUpdate(pack);
//        session.saveOrUpdate(love);

        User user = session.get(User.class, 2);
        user.getPublications().forEach(p -> System.out.println("User "+ user.getUserName() + " publication "+ p.getText()));

        session.getTransaction().commit();
        session.close();
    }
}
