package com.upax.upax.service;

import com.upax.upax.models.Employee;
import com.upax.upax.models.Gender;
import com.upax.upax.models.Job;

import java.util.List;

public interface EmployeService {

    List<Employee> getAllEmployees();
    List<Employee> findByJob(Job job);
    List<Employee> findByGender(Gender gender);
    Employee getEmployee(Long id);
    Employee createEmployee (Employee employee);
    List <Employee> findByNameAndLastName(String name, String lastName);

}
