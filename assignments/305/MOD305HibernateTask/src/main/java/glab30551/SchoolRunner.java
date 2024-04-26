package glab30551;

import glab30551.model.Department;
import glab30551.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class SchoolRunner {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure("schoolDemo.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();

        try {
//            manyToOne(session);
            oneToMany(session);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sf.close();
        }
    }

    public static void oneToMany(Session session) {
        Transaction trans = session.beginTransaction();
        try {
            Teacher t1 = new Teacher("1000", "MHaseeb");
            Teacher t2 = new Teacher("2220", "Shahparan");
            Teacher t3 = new Teacher("3000", "James");
            Teacher t4 = new Teacher("40000", "Joseph");
            Teacher t5 = new Teacher("200", "Ali");

            //Add teacher entity object to the list
            ArrayList<Teacher> teachersList = new ArrayList<>();
            teachersList.add(t1);
            teachersList.add(t2);
            teachersList.add(t3);
            teachersList.add(t4);
            teachersList.add(t5);
            session.persist(t1);
            session.persist(t2);
            session.persist(t3);
            session.persist(t4);
            session.persist(t5);

            //Creating Department
            Department department = new Department();
            department.setDeptName("Development");
            department.setTeacherList(teachersList);

            //Storing Department
            session.persist(department);
            trans.commit();

        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void manyToOne(Session session) {
        Transaction trans = session.beginTransaction();

        try {

//        creating departments
            Department dept1 = new Department("IT");
            Department dept2 = new Department("HR");

//        creating teachers
            Teacher t1 = new Teacher("1000", "MHaseeb", dept1);
            Teacher t2 = new Teacher("2220", "Shahparan", dept1);
            Teacher t3 = new Teacher("3000", "James", dept1);
            Teacher t4 = new Teacher("40000", "Joseph", dept2);

            //Storing Departments in database
            session.persist(dept1);
            session.persist(dept2);

            //Storing teachers  in database
            session.persist(t1);
            session.persist(t2);
            session.persist(t3);
            session.persist(t4);

            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }


    }
}

