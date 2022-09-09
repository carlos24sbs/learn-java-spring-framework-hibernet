package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.oneToOne.Carnet;
import com.springsimplespasos.hibernate.entidades.oneToOne.Socio;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class MainOneToOne {
    public static void main(String[] args){
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();
        Carnet carnet = new Carnet();
        carnet.setNumero("0000000006");

        Socio socio = new Socio();
        socio.setNombre("Juan");
        socio.setDocumento("000000000006");
//        socio.setCarnet(carnet);
        carnet.setSocio(socio);

        session.beginTransaction();
        session.save(carnet);

        session.getTransaction().commit();
        session.close();
    }
}
