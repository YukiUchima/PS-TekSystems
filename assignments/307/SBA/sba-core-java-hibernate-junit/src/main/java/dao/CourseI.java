package dao;
//<!-- Yuki Uchima          -->
//<!-- Class: 2024-RTT-105  -->
import model.Course;
import java.util.List;

public interface CourseI {
    void createCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(int courseId);

}
