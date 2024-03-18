package com.quintus.controller;

import com.quintus.pojo.Student;
import com.quintus.service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll(){
        List<Student> allStudent= studentService.findAll();
        System.out.println("所有学生数据为: " + allStudent);
    }
}
