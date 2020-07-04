package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Course;
import com.zkzong.mybatis.domain.Tutor;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by Zong on 2017/3/11.
 */
public class TutorServiceTest {
    private static TutorService tutorService;

    @BeforeClass
    public static void setUp() throws Exception {
        tutorService = new TutorService();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        tutorService = null;
    }

    @Test
    public void findTutorById() throws Exception {
        Tutor tutor = tutorService.findTutorById(1);
        Assert.assertNotNull(tutor);
        List<Course> courses = tutor.getCourses();
        Assert.assertNotNull(courses);
        for (Course course : courses) {
            Assert.assertNotNull(course);
            System.out.println(course);
        }
    }

    @Test
    public void selectTutorWithCourses() throws Exception {
        Tutor tutor = tutorService.selectTutorWithCourses(1);
        Assert.assertNotNull(tutor);
        List<Course> courses = tutor.getCourses();
        Assert.assertNotNull(courses);
        for (Course course : courses) {
            Assert.assertNotNull(course);
            System.out.println(course);
        }
    }

}