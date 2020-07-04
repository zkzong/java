package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Course;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2017/3/11.
 */
public class CourseServiceTest {
    private static CourseService courseService;

    @BeforeClass
    public static void setUp() throws Exception {
        courseService = new CourseService();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        courseService = null;
    }

    @Test
    public void selectCoursesByTutor() {
        List<Course> courses = courseService.selectCoursesByTutor(1);
        Assert.assertNotNull(courses);
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Test
    public void searchCourses() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tutorId", 1);
//        map.put("courseName", "%java%");
//        map.put("startDate", new Date());
        List<Course> courses = courseService.searchCourses(map);
        Assert.assertNotNull(courses);
        for (Course course : courses) {
            Assert.assertNotNull(course);
            System.out.println(course);
        }
    }

    @Test
    public void searchCoursesByTutors() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
//        List<Integer> tutorIds = new ArrayList<Integer>();
//        tutorIds.add(1);
//        tutorIds.add(2);
        map.put("tutorIds", "1, 2");
//        map.put("courseName", "%java%");
//        map.put("startDate", new Date());
//        int[] tutorIds = {1, 2};
        List<Course> courses = courseService.searchCoursesByTutors(map);
        Assert.assertNotNull(courses);
        for (Course course : courses) {
            Assert.assertNotNull(course);
            System.out.println(course);
        }
    }

}