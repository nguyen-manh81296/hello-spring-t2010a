package com.aptech.hellospring.t2010a.controller;

import com.aptech.hellospring.t2010a.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *http://localhost:8080/api/v1/students | GET   | return list student
 *http://localhost:8080/api/v1/students | POST | create new student
 *http://localhost:8080/api/v1/students/1 | DELETE| remove student
 * http://localhost:8080/api/v1/students/1 | GET| find student by id
 * http://localhost:8080/api/v1/students/1 | PUT | update student
 */

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    static List<Student> list;

    public StudentController() {
        list = new ArrayList<>();
        list.add(Student.builder().rollNumber("A001").fullName("Hung").build());
        list.add(Student.builder().rollNumber("A002").fullName("Xuan").build());
        list.add(Student.builder().rollNumber("A003").fullName("Sang").build());
        list.add(Student.builder().rollNumber("A004").fullName("Thu").build());
        list.add(Student.builder().rollNumber("A005").fullName("Dong").build());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll() {
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        list.add(student);
        return student;
    }

    //Path Variable
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Student findById(@PathVariable String id) {
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)) {
                foundIndex = -1;
                break;
            }
        }
        if (foundIndex == -1) {
            return null;
        }
        return list.get(foundIndex);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public boolean deleteById(@PathVariable String id) {
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)) {
                foundIndex = -1;
                break;
            }
        }
        if (foundIndex == -1) {
            return false;
        }
        list.remove(foundIndex);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public Student update(@PathVariable String id, @RequestBody Student updateStudent) {
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)) {
                foundIndex = -1;
                break;
            }
        }
        if (foundIndex == -1) {
            return null;
        }
        Student existing = list.get(foundIndex);
        existing.setFullName(updateStudent.getFullName());
        return existing;
    }
}
