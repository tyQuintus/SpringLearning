package com.quintus.service.imple;

import com.quintus.dao.StudentDao;
import com.quintus.pojo.Student;
import com.quintus.service.StudentService;

import java.util.List;

public class StudentServiceImp implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        return studentList;
    }
}
