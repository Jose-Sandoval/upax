package com.upax.upax.repository;

import com.upax.upax.models.Employee;
import com.upax.upax.models.Gender;
import com.upax.upax.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    List<Employee> findByJob (Job job);
    List <Employee> findByGender(Gender gender);
    @Query("Select e FROM Employee e where e.name=?1 and e.lastName=?2")
    List <Employee> findByNameAndLastName(String name, String lastName);
}
