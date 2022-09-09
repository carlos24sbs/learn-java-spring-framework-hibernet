package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manytoone.Person;
import com.springsimplespasos.hibernate.entidades.manytoone.Phone;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class JpqlMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();
//        SQL native: SELECT * FROM Person WHERE id = ?
        Query query = session.createQuery("select p from Person p where p.id =?1");
        query.setParameter(1, Integer.parseInt("1"));
        Person person = (Person) query.getSingleResult();
        System.out.println(person.getName());
//        SELECT * FROM persona p JOIN phone t ON p.id = t.person_id where p.id = ?
        Query phoneQuery = session.createQuery("select p.phones from Person p where p.id = :id");
        phoneQuery.setParameter("id", Integer.parseInt("1"));
        List<Phone> phones = (List<Phone>) phoneQuery.getResultList();
        phones.forEach(phone -> System.out.println(phone.getNumber()));

        session.close();
    }
}
