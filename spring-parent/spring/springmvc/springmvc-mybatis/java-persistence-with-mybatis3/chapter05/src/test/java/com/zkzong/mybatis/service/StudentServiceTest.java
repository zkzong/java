package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.PhoneNumber;
import com.zkzong.mybatis.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Zong on 2017/3/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

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
    public void testFindStudentWithAddressById() {
        Student student = studentService.findStudentWithAddressById(1);
        assertNotNull(student);
        System.out.println(student);
    }

    @Test
    public void testCreateStudent() {
        Student stud = new Student();
        long ts = System.currentTimeMillis();
        stud.setName("stud_" + ts);
        stud.setEmail("stud_" + ts + "@gmail.com");
        stud.setPhone(new PhoneNumber("123-456-7890"));
        Student student = studentService.createStudent(stud);
        assertNotNull(student);
        assertEquals("stud_" + ts, student.getName());
        assertEquals("stud_" + ts + "@gmail.com", student.getEmail());
        System.out.println("Created Student:" + student);

    }

    @Test
    public void testCreateStudentWithMap() {
        Map<String, Object> studMap = new HashMap<String, Object>();
        long ts = System.currentTimeMillis();
        studMap.put("name", "stud_" + ts);
        studMap.put("email", "stud_" + ts + "@gmail.com");
        studMap.put("phone", null);
        studentService.createStudentWithMap(studMap);
    }

    @Test
    public void testUpdateStudent() {
        Student stud = new Student();
        long ts = System.currentTimeMillis();
        stud.setStudId(2);
        stud.setName("stud_" + ts);
        stud.setEmail("stud_" + ts + "@gmail.com");
        Student updatedStudent = studentService.updateStudent(stud);
        assertNotNull(updatedStudent);
        assertEquals("stud_" + ts, updatedStudent.getName());
        assertEquals("stud_" + ts + "@gmail.com", updatedStudent.getEmail());

    }

    @Test
    public void testDeleteStudent() {
        boolean deleteStudent = studentService.deleteStudent(3);
        assertTrue(deleteStudent);
        System.out.println("deleteStudent:" + deleteStudent);
    }
    
    @Test
    public void testFindStudentMapById() {
        Map<String, Object> studentMap = studentService.findStudentMapById(1);
        System.out.println(studentMap);
    }

    @Test
    public void testFindAllStudentsMap() {
        List<Map<String, Object>> studentMapList = studentService.findAllStudentsMap();
        for (Map<String, Object> studentMap : studentMapList) {
            System.out.println("id : " + studentMap.get("studId"));
            System.out.println("name : " + studentMap.get("name"));
            System.out.println("email : " + studentMap.get("email"));
            System.out.println("phone : " + studentMap.get("phone"));

        }
    }

}