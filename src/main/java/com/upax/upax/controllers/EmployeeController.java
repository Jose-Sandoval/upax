package com.upax.upax.controllers;

import com.upax.upax.models.Employee;
import com.upax.upax.models.Job;
import com.upax.upax.models.responses.ResponseEmployees;
import com.upax.upax.service.EmployeService;
import com.upax.upax.service.GenderService;
import com.upax.upax.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeService employeService;

    @Autowired
    private GenderService genderService;

    @Autowired
    private JobService jobService;

    @GetMapping("/prueba")
    public String prueba(){
        return "Hola mundo";
    }

    @GetMapping
    public  ResponseEntity <List<Employee>> getAllEmployees(){
        List <Employee> employees = new ArrayList<>();
        employees = employeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseEmployees.Response> save(@RequestBody Employee employee){
        ResponseEmployees.Response response = new ResponseEmployees.Response();
        //System.out.println(employeService.findByNameAndLastName(employee.getName(), employee.getLastName()));
        if (obtenerAnios(employee.getBirthdate())>17
                && (employeService.findByNameAndLastName(employee.getName(), employee.getLastName())).size()<1
                && null != genderService.getGender(employee.getGender().getId())
                && null != jobService.getJob(employee.getJob().getId())) {
            Employee newEmployee = employeService.createEmployee(employee);
            System.out.println(newEmployee);
            response.setId(newEmployee.getId());
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else
            response.setSuccess(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @PostMapping("/jobs")
    public ResponseEntity<ResponseEmployees> listEmployeeByJob(@RequestBody Job job){
        ResponseEmployees responseEmployees = new ResponseEmployees();
        if(null != job.getId()) {
            System.out.println(job);

            if (null != jobService.getJob(job.getId())) {
                responseEmployees.setEmployees(employeService.findByJob(Job.builder().id(job.getId()).build()));
                responseEmployees.setSuccess(true);
                return ResponseEntity.ok(responseEmployees);
            } else
                responseEmployees.setSuccess(false);
            return ResponseEntity.ok(responseEmployees);
        }else {
            System.out.println("job no valido");
            return null;
        }
    }

    public static int obtenerAnios(Date cumple) {
        LocalDate ahora = LocalDate.now();
        int a= ahora.getYear();
        int m = ahora.getMonthValue();
        int d = ahora.getDayOfMonth();

        Calendar b = getCalendar(cumple);
        int dia = b.get(Calendar.DATE)+1;
        int mes = b.get(Calendar.MONTH)+1;
        int annio = b.get(Calendar.YEAR);

        int diff = a - annio;
        if (mes > m ||  (mes == m && dia > d )){
            diff--;
        }

        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

}
