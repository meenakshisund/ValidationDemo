package com.example.validation.config;

import com.example.validation.domain.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.stream.Collectors;

@Component
public class RequestParamInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(RequestParamInterceptor.class);

    private Student replacedStudent = new Student();

    @Autowired
    private ObjectMapper objectMapper;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if("POST".equalsIgnoreCase(request.getMethod())) {
            BufferedReader br = request.getReader();
            String object = br.lines().collect(Collectors.joining());
            Student student = objectMapper.readValue(object, Student.class);

            logger.info(student.getName() + " " + student.getGrade() + " " + student.getAge());

            replacedStudent.setAge(student.getAge() + 1);
            replacedStudent.setGrade(student.getGrade() + 1);
            replacedStudent.setName(student.getName() + "Hello");
            request.setAttribute("student", replacedStudent);
        }
        return true;
    }
}
