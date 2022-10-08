package com.velocity.practice.springbootdemo.Service;

import com.velocity.practice.springbootdemo.Model.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    List<Customer> getCustomersContaining(String str);

    Customer updateCustomerById(Customer customer, Long customerId);

    void deleteCustomer(Long customerID);
}
