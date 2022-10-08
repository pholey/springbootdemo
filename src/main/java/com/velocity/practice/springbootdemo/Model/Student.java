package com.velocity.practice.springbootdemo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private String studentRollNo;
    private String studentAddress;
}
