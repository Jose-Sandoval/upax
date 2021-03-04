package com.upax.upax.controllers;

import com.upax.upax.models.EmployeeWork;
import com.upax.upax.models.Hours;
import com.upax.upax.models.responses.Payments;
import com.upax.upax.models.responses.WorkedHousr;
import com.upax.upax.service.EmployeService;
import com.upax.upax.service.HoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.sql.Date;

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
    public ResponseEntity<WorkedHousr> contar(@RequestBody EmployeeWork employeeWork){
        WorkedHousr workedHousr = new WorkedHousr();
        Integer hours;
        System.out.println(employeeWork);
        if(null != employeService.getEmployee(employeeWork.getEmployee_id()) && employeeWork.getStart_date().before(employeeWork.getEnd_date()) ){
            hours  = hoursService.countHours(employeeWork.getEmployee_id(),
                    employeeWork.getStart_date(),
                    employeeWork.getEnd_date());
            if (null!=hours){
                workedHousr.setTotal_worked_hours(hours);
                workedHousr.setSuccess(true);
            }else
                workedHousr.setSuccess(false);
            return ResponseEntity.ok(workedHousr);
        }else
            workedHousr.setSuccess(false);
        return ResponseEntity.ok(workedHousr);
    }

    @PostMapping("/amount")
    public ResponseEntity<Payments> sumar(@RequestBody EmployeeWork employeeWork){
        System.out.println(employeeWork);
        Payments payments = new Payments();
        if(null != employeService.getEmployee(employeeWork.getEmployee_id()) && employeeWork.getStart_date().before(employeeWork.getEnd_date()) ){
            Integer horas = hoursService.countHours(employeeWork.getEmployee_id(), employeeWork.getStart_date(), employeeWork.getEnd_date());
            Double salary = employeService.getEmployee(employeeWork.getEmployee_id()).getJob().getSalary();
            if (null!= horas && null != salary) {
                payments.setPayment(horas * salary);
                payments.setSuccess(true);
            }else
                payments.setSuccess(false);
            return ResponseEntity.ok(payments);
        }else
            payments.setSuccess(false);
        return ResponseEntity.ok(payments);
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
