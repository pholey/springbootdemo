package com.velocity.practice.springbootdemo.Controller;

import com.velocity.practice.springbootdemo.Model.Customer;
import com.velocity.practice.springbootdemo.Service.CustomerService;
import com.velocity.practice.springbootdemo.payLoads.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer)
    {
        //log.error("cgfdgfg");
        Customer customer1 = this.customerService.saveCustomer(customer);
        return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers()
    {
        List<Customer> customerList = customerService.getAllCustomers();
        System.out.println(customerList);
        return customerList;
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id)
    {
        Customer customer = this.customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/customers/{str}")
    public List<Customer> getCustomersContaining(@PathVariable("str") String name)
    {
        List<Customer> customers = this.customerService.getCustomersContaining(name);
        return customers;
    }

    @GetMapping("/customerName/{name}")
    public String getCustomerName(@PathVariable("name") String name )
    {
        return "Hi " + name;
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomerById(@RequestBody Customer customer, @PathVariable ("customerId") Long custId)
    {
        Customer updatedCustomer = this.customerService.updateCustomerById(customer,custId);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable ("customerId") Long cId){
        this.customerService.deleteCustomer(cId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true),
                                                                    HttpStatus.OK);
    }

}
