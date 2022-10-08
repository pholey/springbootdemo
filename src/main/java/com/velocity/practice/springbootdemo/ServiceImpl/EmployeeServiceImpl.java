package com.velocity.practice.springbootdemo.ServiceImpl;

import com.velocity.practice.springbootdemo.Model.Employee;
import com.velocity.practice.springbootdemo.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Override
    public List<Employee> getEmployees() {

        Employee pallavi = new Employee().builder().name("Pallavi").city("Pune").age(26).build();
        Employee sachin = new Employee().builder().name("Sachin").city("Pune").age(28).build();
        Employee sanket = new Employee().builder().name("Sanket").city("Pune").age(23).build();
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(pallavi);
        employeeList.add(sachin);
        employeeList.add(sanket);

        return employeeList.stream().filter(x -> x.getAge() > 25).collect(Collectors.toList());
    }
}
