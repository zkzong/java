package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Address;
import com.zkzong.mybatis.domain.Student;
import com.zkzong.mybatis.mapper.AddressMapper;
import com.zkzong.mybatis.mapper.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2017/3/10.
 */
@Service
@Transactional
public class StudentService {

//    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private AddressMapper addressMapper;

    public List<Student> findAllStudents() {
        return studentMapper.findAllStudents();
    }

    public List<Map<String, Object>> findAllStudentsMap() {
        return studentMapper.findAllStudentsMap();
    }

    public Student findStudentById(Integer studId) {
        return studentMapper.findStudentById(studId);
    }

    public Map<String, Object> findStudentMapById(Integer studId) {
        return studentMapper.findStudentMapById(studId);
    }

    public Student findStudentWithAddressById(int id) {
        return studentMapper.selectStudentWithAddress(id);
    }

    public Student createStudent(Student student) {
        Address address = student.getAddress();
        if (address != null) {
            addressMapper.insertAddress(address);
        }
        if (student.getName() == null || student.getName().trim().length() == 0) {
            throw new RuntimeException("Student Name should not be null");
        }
        studentMapper.insertStudent(student);
        return student;
    }

    public void createStudentWithMap(Map<String, Object> studentDataMap) {
        studentMapper.insertStudentWithMap(studentDataMap);
    }

    public Student updateStudent(Student student) {
        studentMapper.updateStudent(student);
        return student;
    }

    public boolean deleteStudent(int id) {
        int count = studentMapper.deleteStudent(id);
        return count > 0;
    }
}
