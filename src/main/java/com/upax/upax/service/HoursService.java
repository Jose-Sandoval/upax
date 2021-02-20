package com.upax.upax.service;

import com.upax.upax.models.*;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface HoursService {

    List <Hours> findByemployeeId(Employee employee);
    List <Hours> findByDate(Date date);
    Hours createHours(Hours hours);
    Integer countHours( Long id, Date start_date,Date end_date);
}
