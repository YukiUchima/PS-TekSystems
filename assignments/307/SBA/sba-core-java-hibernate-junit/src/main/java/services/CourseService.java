package services;

import dao.CourseI;
import model.Course;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.List;
//<!-- Yuki Uchima          -->
//<!-- Class: 2024-RTT-105  -->
/**
 * CourseService is a concrete class. This class implements the
 * CourseI interface, overrides all abstract service methods and
 * provides implementation for each method.
 */
public class CourseService implements CourseI {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session session;

    @Override
    public void createCourse(Course newCourse) {
        session = sf.openSession();
        Transaction t = session.beginTransaction();
        try {
            String hql = "FROM Course WHERE name=:courseName and instructor=:instructorName";
            TypedQuery<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("courseName",newCourse.getName());
            query.setParameter("instructorName",newCourse.getInstructor());

            List<Course> results = query.getResultList();
            if (results.isEmpty()) {
                session.persist(newCourse);
            }
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (t != null) {
                t.rollback();
            }
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Course> getAllCourses() {
        session = sf.openSession();
        try {
            String hql = "FROM Course";
            TypedQuery<Course> query = session.createQuery(hql, Course.class);
            List<Course> courses = query.getResultList();
            if (!courses.isEmpty()) {
                return courses;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Course getCourseById(int courseId) {
        session = sf.openSession();
        try {
            String hql = "FROM Course WHERE id=:id";
            TypedQuery<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("id", courseId);

            List<Course> courses = query.getResultList();
            if (!courses.isEmpty()) {
                return courses.getFirst();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }
}
