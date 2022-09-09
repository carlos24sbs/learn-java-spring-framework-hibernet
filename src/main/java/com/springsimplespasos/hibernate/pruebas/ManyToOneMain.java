package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manytoone.Person;
import com.springsimplespasos.hibernate.entidades.manytoone.Phone;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;

public class ManyToOneMain {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();

        Person juan = new Person(1, "Juan");
        Person mariana = new Person(2, "Mariana");

        Phone cel1 = new Phone(null, "0000000001",juan);
        Phone cel2 = new Phone(null, "0000000002", juan);
        Phone cel3 = new Phone(null, "0000000003", mariana);

        session.beginTransaction();
        juan.setPhones(Arrays.asList(cel1, cel2));
        mariana.setPhones(Arrays.asList(cel3));

//        session.saveOrUpdate(juan);
//        session.saveOrUpdate(mariana);
        Person entity = session.get(Person.class, 2);
        entity.getPhones().forEach(t-> System.out.println(entity.getName() + " Phone:"+ t.getNumber()));

        session.getTransaction().commit();
        session.close();
    }

}
