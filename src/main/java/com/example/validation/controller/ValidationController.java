package com.example.validation.controller;

import com.example.validation.domain.Student;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @ModelAttribute("student")
    Student fetchStudentProcessedFromInterceptor(HttpServletRequest request) {
        return (Student) request.getAttribute("student");
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String getStudentDetails(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        String errorMessage = processBindingResult(bindingResult);
        if(student.getAge()-5 >= student.getGrade())
            return student.getName() + " is " + student.getAge() + " years old studying in grade " + student.getGrade() + " ";
        else
            return student.getName() + " " + errorMessage;
    }

    private String processBindingResult(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(fieldErrors.size() > 0){
            return fieldErrors.get(0).getDefaultMessage();
        }
        return "";
    }
}