package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Student;

import java.sql.*;

/**
 * Created by Zong on 2017/3/7.
 */
public class JdbcStudentService {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mybatis";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        JdbcStudentService service = new JdbcStudentService();

        Student existingStudent = service.findStudentById(1);
        System.out.println(existingStudent);

        long ts = System.currentTimeMillis();
        Student newStudent = new Student(0, "student_" + ts, "student_" + ts + "@gmail.com", new java.util.Date());
        service.createStudent(newStudent);
        System.out.println(newStudent);

        int updateStudId = 3;
        Student updateStudent = service.findStudentById(updateStudId);
        ts = System.currentTimeMillis();
        updateStudent.setEmail("student_" + ts + "@gmail.com");
        service.updateStudent(updateStudent);
    }

    private Student findStudentById(int studId) {
        Student student = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getDatabaseConnection();
            String sql = "select * from students where stud_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setStudId(rs.getInt("stud_id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    private void createStudent(Student student) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getDatabaseConnection();
            String sql = "INSERT INTO STUDENTS(STUD_ID,NAME,EMAIL,DOB) VALUES(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, student.getStudId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getEmail());
            pstmt.setDate(4, new Date(student.getDob().getTime()));
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateStudent(Student student) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getDatabaseConnection();
            String sql = "UPDATE STUDENTS SET NAME=?,EMAIL=?,DOB=? WHERE STUD_ID=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setDate(3, new Date(student.getDob().getTime()));
            pstmt.setInt(4, student.getStudId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(JdbcStudentService.DRIVER);
            return DriverManager.getConnection(JdbcStudentService.URL,
                    JdbcStudentService.USERNAME,
                    JdbcStudentService.PASSWORD);
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (SQLException e) {
            throw e;
        }
    }
}
