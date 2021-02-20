package com.upax.upax.controllers;

import com.upax.upax.models.EmployeeWork;
import com.upax.upax.models.Hours;
import com.upax.upax.service.EmployeService;
import com.upax.upax.service.HoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/hours")
public class HoursController {

    @Autowired
    private HoursService hoursService;

    @Autowired
    private EmployeService employeService;

    @GetMapping
    public String prueba(){
        return "Hola horas";
    }

    @PostMapping("/save")
    public ResponseEntity<Hours> save(@RequestBody Hours hours){
        Hours newHours = hoursService.createHours(hours);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHours);
    }

    @PostMapping("/count")
    public ResponseEntity<Integer> contar(@RequestBody EmployeeWork employeeWork){
        System.out.println(employeeWork);
        return ResponseEntity.ok(hoursService.countHours(employeeWork.getEmployee_id(),employeeWork.getStart_date(), employeeWork.getEnd_date()));
    }

    @PostMapping("/amount")
    public ResponseEntity<Double> sumar(@RequestBody EmployeeWork employeeWork){
        System.out.println(employeeWork);
        Integer horas = hoursService.countHours(employeeWork.getEmployee_id(), employeeWork.getStart_date(), employeeWork.getEnd_date());
        Double salary = employeService.getEmployee(employeeWork.getEmployee_id()).getJob().getSalary();
        return ResponseEntity.ok(horas*salary);
    }

    public String validation(){
        return null;
    }

    public String FormatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(sdf.format(date));
        return sdf.format(date);
    }

}
