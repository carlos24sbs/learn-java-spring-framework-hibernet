package com.springsimplespasos.hibernate.entidades.manytoone;

import javax.persistence.*;

@Entity
@Table
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, length = 10, nullable = false)
    private String number;

    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "FK_PERSONA_ID"))
    private Person person;

    public Phone() {
    }

    public Phone(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public Phone(Integer id, String number, Person person) {
        this.id = id;
        this.number = number;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}
