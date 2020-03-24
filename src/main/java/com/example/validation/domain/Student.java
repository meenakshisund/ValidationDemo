package com.example.validation.domain;

import javax.validation.constraints.*;
import java.io.Serializable;

public class Student implements Serializable {

    @DecimalMin(value = "5", message = "Student age should be minimum 5")
    @DecimalMax(value = "18", message = "Student age should be maximum 18")
    private Integer age;

    @DecimalMin(value = "1", message = "grade should be minimum 1")
    @DecimalMax(value = "12", message = "grade should be maximum 12")
    private Integer grade;

    @NotNull
    @NotBlank
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
