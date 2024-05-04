import model.Course;
import model.Student;
//<!-- Yuki Uchima          -->
//<!-- Class: 2024-RTT-105  -->
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import services.CourseService;
import services.StudentService;
import utils.CommandLine;
import utils.HibernateUtil;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest extends StudentService {
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();


    @BeforeAll
    static void initialize() {
        //    Ensure db has all necessary student and course data
        CommandLine.addData();
    }

    @Test
    public void testGetStudentByEmail() {
        Student student = studentService.getStudentByEmail("annette@gmail.com");
        assertNotNull(student, "Student search failed.");
    }

    @Test
    public void testCreateStudent() {
        Student createdstudent = new Student("new@gmail.com", "genericname", "newpassword");
        studentService.createStudent(createdstudent);
        boolean expectedResult = true;
        boolean actualResult = studentService.getAllStudents().contains(createdstudent);

        assertEquals(expectedResult, actualResult, "Student creation failed.");
    }

    @Test
    public void testValidateStudent() {
        boolean expectedResult = true;
        boolean actualResult = studentService.validateStudent("bolaji@gmail.com", "password");
        assertEquals(expectedResult, actualResult, "Validation of student failed.");
    }

    @Test
    public void testNoDuplicateStudent() {
        Student duplicateStudent = new Student("duplicate@gmail.com", "duplicateName", "duplicatePassword");

        int expectedResult = 1;

        studentService.createStudent(duplicateStudent);
        studentService.createStudent(duplicateStudent);

        List<Student> studentList = studentService.getAllStudents();
        int actualResult = Collections.frequency(studentList, duplicateStudent);

        assertNotNull(actualResult, "No student was found.");
        assertEquals(expectedResult, actualResult, "Duplicate students created.");
    }

    //    TODO
//    @ParameterizedTest
//    @ValueSource(strings = {"anthony@gmail.com",
//            "ariadna@gmail.com",
//            "reema@gmail.com",
//    })
    @Test
    public void testRegisterStudentToCourse() {
        Student currentStudent = studentService.getStudentByEmail("ariadna@gmail.com");
        Course course = courseService.getCourseById(2);
        studentService.registerStudentToCourse("ariadna@gmail.com", 2);

        boolean expected = true;

        boolean actual = studentService.getStudentCourses("ariadna@gmail.com").contains(course);
        boolean actual2 = course.getStudents().contains(currentStudent);

        System.out.println(actual);
        System.out.println(actual2);

        assertEquals(expected, actual, "Student has not registered to the course.");
    }

    @AfterAll
    static void shutdown() {
        HibernateUtil.shutdown();
    }
}
