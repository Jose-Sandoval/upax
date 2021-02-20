package com.upax.upax.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee_worked_hours")
@Data
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column( name = "worked_hours")
    private int worked_hours;

    @Column(name = "worked_date")
    private Date date;

}
