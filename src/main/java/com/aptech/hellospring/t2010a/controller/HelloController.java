package com.aptech.hellospring.t2010a.controller;

import com.aptech.hellospring.t2010a.entity.Student;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "api/hello")
public class HelloController {

    @RequestMapping(path = "world",method = RequestMethod.GET)
    public String say() { return "Hello World"; }

    @RequestMapping(path = "talk",method = RequestMethod.GET)
    public String talk() { return "Talk to world"; }

    @RequestMapping(path = "student",method = RequestMethod.GET)
    public Student getStudent() {
        return Student.builder()
                .rollNumber("A001")
                .fullName("Hong Xuan")
                .phone("091232232")
                .address("Hanoi Vietnam")
                .dob(LocalDateTime.of(2007,10,10,10,9,0))
                .build();

    }
}
