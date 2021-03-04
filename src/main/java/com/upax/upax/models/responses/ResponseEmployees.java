package com.upax.upax.models.responses;

import com.upax.upax.models.Employee;
import lombok.Data;

import java.util.List;

@Data
public class ResponseEmployees {

    private List<Employee> employees;

    private boolean success;

    @Data
    public static class Response {
        private Long id;
        private boolean success;
    }
}
