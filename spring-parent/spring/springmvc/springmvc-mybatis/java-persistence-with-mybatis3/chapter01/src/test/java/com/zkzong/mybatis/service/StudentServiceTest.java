package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Zong on 2017/3/7.
 */
public class StudentServiceTest {
    private static StudentService studentService;

    @Before
    public void setUp() throws Exception {
        studentService = new StudentService();
//        TestDataPopulator.initDatabase();
    }

    @After
    public void tearDown() throws Exception {
        studentService = null;
    }

    @Test
    public void testFindAllStudents() {
        List<Student> students = studentService.findAllStudents();
        assertNotNull(students);
        for (Student student : students) {
            assertNotNull(student);
            System.out.println(student);
        }
    }

    @Test
    public void testFindStudentById() {
        Student student = studentService.findStudentById(1);
        assertNotNull(student);
        System.out.println(student);
    }

    @Test
    public void testCreateUStudent() {
        Student student = new Student();
        int id = 4;
        student.setStudId(id);
        student.setName("student_" + id);
        student.setEmail("student_" + id + "gmail.com");
        student.setDob(new Date());
        studentService.createStudent(student);;
        Student newStudent = studentService.findStudentById(id);
        assertNotNull(newStudent);
        assertEquals("student_" + id, newStudent.getName());
        assertEquals("student_" + id + "gmail.com", newStudent.getEmail());
    }

    @Test
    public void testUpdateStudent() {
        int id = 2;
        Student student = studentService.findStudentById(id);
        student.setStudId(id);
        student.setName("student_" + id);
        student.setEmail("student_" + id + "gmail.com");
        Date now = new Date();
        student.setDob(now);
        studentService.updateStudent(student);
        Student updateStudent = studentService.findStudentById(id);
        assertNotNull(updateStudent);
        assertEquals("student_" + id, updateStudent.getName());
        assertEquals("student_" + id + "gmail.com", updateStudent.getEmail());
    }

}