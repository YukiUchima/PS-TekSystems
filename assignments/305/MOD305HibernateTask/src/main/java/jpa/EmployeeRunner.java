package jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static jpa.controller.EmployeeController.*;

public class EmployeeRunner {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("usersdb.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        try{
//            createEmployeeTable(session);
//            findEmployeeByName(session, "Jenny Ji");
//            findEmployeeById(session, 5);
            showOfficeCodes_AsDepartment(session);
        }finally {
            session.close();
            factory.close();
        }
    }
}
