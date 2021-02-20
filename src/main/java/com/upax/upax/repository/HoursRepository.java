package com.upax.upax.repository;

import com.upax.upax.models.Employee;
import com.upax.upax.models.Hours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface HoursRepository extends JpaRepository <Hours, Long> {

    List<Hours> findByEmployeeId (Employee employee);
    List<Hours> findByDate (Date date);
    @Query("SELECT SUM(h.worked_hours) FROM Hours h where h.employee.id=?1 and h.date Between ?2 and ?3 ")
    Integer countHours(Long id, Date start_date, Date end_date);
}
