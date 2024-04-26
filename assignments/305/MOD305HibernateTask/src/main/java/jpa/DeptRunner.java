package jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static jpa.controller.DepartmentController.*;

public class DeptRunner {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("usersdb.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

//        Scanner input = new Scanner(System.in);

        try {
//            addDept(session);
//            updateDept(session, input, 2);
            findDept(session, 3);
            deleteDept(session, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.close();
        factory.close();

    }
}
