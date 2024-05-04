//<!-- Yuki Uchima          -->
//<!-- Class: 2024-RTT-105  -->

import model.Course;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import services.CourseService;
import utils.CommandLine;
import utils.HibernateUtil;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CourseServiceTest {

    private static final CourseService courseService = new CourseService();

    @BeforeAll
    static void initialize() {
        //    Ensure db has all necessary student and course data
        CommandLine.addData();
    }

    @Test
    public void testGetCourseById() {
        Course course = courseService.getCourseById(1);

        Boolean expectedResult = true;
        Course testCourseObject = new Course("Java", "Roger Boaitey");
        Boolean actualResult = courseService.getCourseById(1).equals(testCourseObject);

        System.out.println(courseService.getCourseById(1));
        System.out.println(testCourseObject);
        assertNotNull(course, "Course search failed.");
        assertEquals(expectedResult,actualResult, "Course entry not same.");
    }

    @Test
    public void testCreateCourse() {
        Course createdcourse = new Course("ReactJS", "Jonas Schmedtmann");
        Course createdcourse2 = new Course("ReactJS", "Ivan Gomes");
        Course createdcourse3 = new Course("Bootstrap", "Ivan Gomes");
        Course createdcourse4 = new Course("Bootstrap", "Jonas Schmedtmann");

        courseService.createCourse(createdcourse);
        courseService.createCourse(createdcourse2);
        courseService.createCourse(createdcourse3);
        courseService.createCourse(createdcourse4);


        boolean expectedResult = true;
        boolean actualResult = courseService.getAllCourses().contains(createdcourse);
        boolean actualResult2 = courseService.getAllCourses().contains(createdcourse2);
        boolean actualResult3 = courseService.getAllCourses().contains(createdcourse3);
        boolean actualResult4 = courseService.getAllCourses().contains(createdcourse4);


        assertEquals(expectedResult, actualResult, "Course creation failed.");
        assertEquals(expectedResult, actualResult2, "Course creation failed.");
        assertEquals(expectedResult, actualResult3, "Course creation failed.");
        assertEquals(expectedResult, actualResult4, "Course creation failed.");

    }

    @Test
    public void testNoDuplicatedCourses() {
        Course duplicateCourse = new Course("-New_Tech-", "-Unknown-");

        int expectedResult = 1;

        courseService.createCourse(duplicateCourse);
        courseService.createCourse(duplicateCourse);

        List<Course> courseList = courseService.getAllCourses();
        int actualResult = Collections.frequency(courseList, duplicateCourse);

        assertNotNull(actualResult, "No course was found.");
        assertEquals(expectedResult, actualResult, "Duplicate course created.");
    }


    @AfterAll
    static void shutdown() {
        HibernateUtil.shutdown();
    }
}
