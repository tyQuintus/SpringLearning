package com.quintus.jdbc;

import com.quintus.controller.StudentController;
import com.quintus.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest {


    public void testForSimple() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        //增
        String sql = "insert into students (id, name, gender,age, class) values (?, ?, ?, ?, ?);";
        int row = jdbcTemplate.update(sql, 9, "+", "男", 18, "高中十班");
        System.out.println("row = " + row);

        //删


        //查
        sql = "select * from students where id = ?;";
        jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setGender(rs.getString("gender"));
            student.setAge(rs.getInt("age"));
            student.setClasses(rs.getString("class"));
            return student;
        }, 9);

        //查
        sql = "select id, name, gender, age, class as classes from students ;";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("studentList = " + studentList);

    }

    @Test
    public void testForXMLIoC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        StudentController studentController = applicationContext.getBean(StudentController.class);
        studentController.findAll();
    }
}
