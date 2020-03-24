package com.example.validation.controller;

import com.example.validation.domain.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String getStudentDetails(@RequestBody @Valid Student student) {
        if(student.getAge()-5 >= student.getGrade())
            return student.getName() + " is " + student.getAge() + " years old studying in grade " + student.getGrade() + " ";
        else
            return student.getName() + " details invalid ";
    }
}