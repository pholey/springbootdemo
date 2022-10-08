package com.velocity.practice.springbootdemo.Controller;

import com.velocity.practice.springbootdemo.Model.Employee;
import com.velocity.practice.springbootdemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/customer/ageAbove25")
    public ResponseEntity<List<Employee>> getCustomerAbove25(){
        List<Employee> empList = employeeService.getEmployees();
        return new ResponseEntity<>(empList, HttpStatus.OK);
    }
}
