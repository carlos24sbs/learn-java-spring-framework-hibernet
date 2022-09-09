package com.springsimplespasos.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "entidades")
public class SampleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    @Column(name = "descripcion", nullable = true, unique = true, length = 70)
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
