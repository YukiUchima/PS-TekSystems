package services;
//<!-- Yuki Uchima          -->
//<!-- Class: 2024-RTT-105  -->
import dao.StudentI;
import model.Course;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * StudentService is a concrete class. This class implements the
 * StudentI interface, overrides all abstract service methods and
 * provides implementation for each method. Lombok @Log used to
 * generate a logger file.
 */
public class StudentService implements StudentI {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session session;

    @Override
    public void createStudent(Student student) {
        Student studentExists = getStudentByEmail(student.getEmail());
        if (studentExists == null) {
            session = sf.openSession();
            Transaction t = session.beginTransaction();
            try {
                session.persist(student);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (t != null) {
                    t.rollback();
                }
            } finally {
                session.close();
            }
        }
    }

    @Override
    public List<Student> getAllStudents() {
        session = sf.openSession();
        try {
            String hql = "FROM Student";
            TypedQuery<Student> query = session.createQuery(hql, Student.class);

            List<Student> students = query.getResultList();
            if (!students.isEmpty()) {
                return students;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Student getStudentByEmail(String email) {
        session = sf.openSession();
        try {
            String hql = "FROM Student WHERE email=:studentEmail";
            TypedQuery<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("studentEmail", email);

            List<Student> student = query.getResultList();
            session.close();
            if (!student.isEmpty()) {
                return student.getFirst();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public boolean validateStudent(String email, String password) {
        try {
            Student currentStudent = getStudentByEmail(email);
            if (currentStudent != null) {
                return currentStudent.getPassword().equals(password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void registerStudentToCourse(String email, int courseId) {
        try {
            Course currentCourse = new CourseService().getCourseById(courseId);
            Student currentStudent = getStudentByEmail(email);

            if (currentCourse != null && currentStudent != null) {
                session = sf.openSession();
                Transaction t = session.beginTransaction();
                try {
                    if (currentStudent.addCourse(currentCourse)) {
                        session.merge(currentStudent);
//                        session.merge(currentCourse);
                    }
                    t.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (t != null) {
                        t.rollback();
                    }
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getStudentCourses(String email) {
        try {
            Student currentStudent = getStudentByEmail(email);
            if (currentStudent != null) {
                Set<Course> courses = currentStudent.getCourses();      // get courses from student
                return new ArrayList<>(courses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
