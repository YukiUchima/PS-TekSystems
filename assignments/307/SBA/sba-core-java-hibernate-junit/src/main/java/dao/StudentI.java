package dao;
//<!-- Yuki Uchima          -->
//<!-- Class: 2024-RTT-105  -->
import model.Course;
import model.Student;
import java.util.List;

public interface StudentI {
    void createStudent(Student student);
    List<Student> getAllStudents();

    Student getStudentByEmail(String email);

    boolean validateStudent(String email, String password);

    void registerStudentToCourse(String email, int courseId);

    List<Course> getStudentCourses(String email);
}
