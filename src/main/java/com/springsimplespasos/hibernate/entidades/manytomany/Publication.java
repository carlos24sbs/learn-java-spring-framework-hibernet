package com.springsimplespasos.hibernate.entidades.manytomany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Publication")
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String text;
    //TODO: Very import using the attribute in other class (publications)
    @ManyToMany(mappedBy = "publications")
    private List<User> users;


    public Publication() {
    }

    public Publication(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Publication(Integer id, String text, List<User> users) {
        this.id = id;
        this.text = text;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
