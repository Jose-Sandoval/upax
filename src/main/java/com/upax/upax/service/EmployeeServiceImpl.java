package com.upax.upax.service;

import com.upax.upax.models.Employee;
import com.upax.upax.models.Gender;
import com.upax.upax.models.Job;
import com.upax.upax.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeService{


    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByJob(Job job) {
        return employeeRepository.findByJob(job);
    }

    @Override
    public List<Employee> findByGender(Gender gender) {
        return employeeRepository.findByGender(gender);
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional <Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent())
            return employee.get();
        else
            return null;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List <Employee> findByNameAndLastName(String name, String lastName) {
        List<Employee> employees = new ArrayList<>();
        employees = employeeRepository.findByNameAndLastName(name, lastName);
        return employees;
    }
}
