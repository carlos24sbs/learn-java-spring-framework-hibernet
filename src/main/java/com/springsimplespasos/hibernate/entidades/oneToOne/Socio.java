package com.springsimplespasos.hibernate.entidades.oneToOne;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Socio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 40)
    private String nombre;
    @Column(unique = true, length = 12)
    private String documento;

    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Carnet carnet;

    public Socio(java.lang.Integer codigo, String nombre, String documento) {
        this.id = codigo;
        this.nombre = nombre;
        this.documento = documento;
    }

    public Socio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }
}
