package com.velocity.practice.springbootdemo.Service;

import com.velocity.practice.springbootdemo.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();
}
