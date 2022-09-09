package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.SampleEntity;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateMain {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();
        session.beginTransaction();
        //#insert
//        SampleEntity sample = new SampleEntity();
//        sample.setName("Descripcion");
//        session.save(sample);
//        session.getTransaction().commit();
        //#update
//        SampleEntity sampleUpdate = new SampleEntity();
//        sampleUpdate.setCode(2);
//        sampleUpdate.setName("Description update-new");
//        session.update(sampleUpdate);

        //#Get
//        SampleEntity sampleRead = session.get(SampleEntity.class, 2);
//        System.out.println(sampleRead.getName());

        SampleEntity sampleUpdate = new SampleEntity();
        sampleUpdate.setCode(2);

        sampleUpdate.setName("Description update-newa");
        SampleEntity sample = new SampleEntity();
        sample.setName("Description all");

        session.saveOrUpdate(sampleUpdate);
        session.saveOrUpdate(sample);
        session.getTransaction().commit();
        session.close();


    }

}
