package com.aptech.hellospring.t2010a.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    public void testCreateStudent(){
        Student student = new Student();
        student.setRollNumber("A001");
        student.setFullName("Xuan hung");
        student.setAddress("Hanoi");
        System.out.println(student.toString());


        System.out.println(Student.builder().rollNumber("A002")
                .fullName("xuan hung")
                .address("Hannoi")
                .phone("000123")
                .build().toString());
    }
}