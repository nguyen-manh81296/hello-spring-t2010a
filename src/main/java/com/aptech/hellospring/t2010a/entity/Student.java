package com.aptech.hellospring.t2010a.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student {
    private String rollNumber;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String note;
    private LocalDateTime dob;
    private int status;
}
