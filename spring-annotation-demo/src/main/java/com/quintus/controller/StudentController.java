package com.quintus.controller;

import com.quintus.pojo.Student;
import com.quintus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void findAll(){
        List<Student> studentList = studentService.findAll();
        System.out.println("studentList:" + studentList);
    }
}
