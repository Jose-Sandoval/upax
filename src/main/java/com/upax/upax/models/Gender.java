package com.upax.upax.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "genders")
@Data
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /*
    public Gender() {}

    public Gender(Long id) {
        this.id = id;
    }

    public Gender(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }*/


}
