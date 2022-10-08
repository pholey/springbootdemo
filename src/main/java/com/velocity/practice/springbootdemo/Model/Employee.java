package com.velocity.practice.springbootdemo.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    private String name;
    private String city;
    private int age;


}
