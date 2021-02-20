package com.upax.upax.models;

import lombok.Data;

import java.sql.Date;

@Data
public class EmployeeWork {

    private Long employee_id;
    private Date start_date;
    private Date end_date;

}
