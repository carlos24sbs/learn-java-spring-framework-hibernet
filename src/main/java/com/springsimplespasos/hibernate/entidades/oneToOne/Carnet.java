package com.springsimplespasos.hibernate.entidades.oneToOne;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Carnet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @MapsId
    private Socio socio;
    @Column(length = 10, unique = true)
    private String numero;

    public Carnet() {
    }

    public Carnet(Integer codigo, String numero) {
        this.id = codigo;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}

