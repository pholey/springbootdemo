package com.velocity.practice.springbootdemo.Repository;

import com.velocity.practice.springbootdemo.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<List<Customer>> findByCustomerNameContaining(String name);
}
