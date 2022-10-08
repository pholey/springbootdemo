package com.velocity.practice.springbootdemo;


import com.velocity.practice.springbootdemo.Model.Customer;
import com.velocity.practice.springbootdemo.Repository.CustomerRepository;
import com.velocity.practice.springbootdemo.ServiceImpl.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    @Test
    public void getAllCustomersShouldReturnEmptyListWhenNoCustomersInDatabase(){
        //prepare
        CustomerRepository customerRepositoryMock = mock(CustomerRepository.class);
        when(customerRepositoryMock.findAll()).thenReturn(new ArrayList<Customer>());

        //execute
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepositoryMock);
        List<Customer> actualCustomerList = customerService.getAllCustomers();

        //test / assert
        Assert.assertEquals(0,actualCustomerList.size());

    }

    @Test
    public void getAllCustomersShouldReturnNonEmptyListWhenCustomersInDatabase(){
        CustomerRepository customerRepositoryMock = mock(CustomerRepository.class);
        Customer cst1 = new Customer(1l,"Sachin","Pune",984545645l);
        Customer cst2 = new Customer(2l,"PAllavi","Pune",984545645l);

        List<Customer> expectedMockList = new ArrayList<Customer>();

        expectedMockList.add(cst1);
        expectedMockList.add(cst2);

        when(customerRepositoryMock.findAll()).thenReturn(expectedMockList);

        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepositoryMock);
        List<Customer> actualCustomerList = customerService.getAllCustomers();

        Assert.assertEquals(expectedMockList,actualCustomerList);

    }
}
