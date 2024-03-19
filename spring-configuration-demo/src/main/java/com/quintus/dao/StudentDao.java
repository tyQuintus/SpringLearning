package com.quintus.dao;

import com.quintus.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> queryAll();
}
