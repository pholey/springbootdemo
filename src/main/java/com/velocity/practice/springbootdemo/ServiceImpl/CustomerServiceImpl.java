package com.velocity.practice.springbootdemo.ServiceImpl;

import com.velocity.practice.springbootdemo.Model.Customer;
import com.velocity.practice.springbootdemo.Repository.CustomerRepository;
import com.velocity.practice.springbootdemo.Service.CustomerService;
import com.velocity.practice.springbootdemo.exception.CustomerNotFoundByDurgeshException;
import com.velocity.practice.springbootdemo.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer customer1 = this.customerRepository.save(customer);
        return customer1;
    }

    @Override
    public List<Customer> getAllCustomers() {
       List<Customer> list = this.customerRepository.findAll();
       return list;
    }

    @Override
    public Customer getCustomerById(Long id) {
      /*  Customer customer = this.customerRepository.findById(id).orElse(null);
        if(customer != null)
        {
            return customer;
        }
        else
        {
            throw new CustomerNotFoundException("Customer for the given id is not present");
        }*/
        Optional<Customer> customerOptional = this.customerRepository.findById(id);
        if(customerOptional.isPresent())
        {
            return customerOptional.get();
        }
        else{
            throw new CustomerNotFoundException("Customer for the given id is not present");
        }
        /*Customer customer = this.customerRepository.findById(id).get();
        return customer;*/
    }

    public List<Customer> getCustomersContaining(String str)
    {
        Optional<List<Customer>> customerOptional = this.customerRepository.findByCustomerNameContaining(str);
        if(customerOptional.isPresent())
        {
            List<Customer> customers = customerOptional.get();
            return customers;
        }
        else
            throw new CustomerNotFoundException("No such Customers found");
    }

    @Override
    public Customer updateCustomerById(Customer customer, Long customerId) {
        Customer customer1 = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundByDurgeshException("Customer", "id", customerId));
        customer1.setCustomerName("Pallavi");
        customer1.setCustomerAddress("Pune");
        customer1.setCustomerMobileNumber(546878745l);
        Customer customer2 = this.customerRepository.save(customer1);

        return customer2;
    }

    @Override
    public void deleteCustomer(Long customerID) {
        Customer customer = this.customerRepository.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundByDurgeshException("Customer","id",customerID));
        this.customerRepository.delete(customer);
    }

}
