package controller;

import model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.Scanner;

//❑ Using Hibernate, create the relevant services for this Model (create, update name/state, find, and delete).
public class DepartmentController {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Scanner input = new Scanner(System.in);

        try {
//            addDept(session);
            updateDept(session, input, 2);
            findDept(session, 3);
//            deleteDept(session, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.close();
        factory.close();

    }

    public static void addDept(Session session){
        Transaction transaction = session.beginTransaction();
        try {
            Department dept1 = new Department("Transportation","Arizona");
            Department dept2 = new Department("Education","California");
            Department dept3 = new Department("Game and Fish","Colorado");
//
            session.persist(dept1);
            session.persist(dept2);
            session.persist(dept3);
//
            transaction.commit();
            System.out.println("Departments added successfully.");
//
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println(e.getMessage());
        }
    }
    public static void updateDept(Session session, Scanner userIn, int deptId){
        Transaction transaction = session.beginTransaction();
        try {
            Department dept = session.get(Department.class, deptId);

            if (dept != null) {
                System.out.println("Please set name of department: ");
                dept.setName(userIn.nextLine());
                System.out.println("Please set which state department is located: ");
                dept.setState(userIn.nextLine());
                session.merge(dept);

                System.out.println("Department updated!");
            } else {
                System.out.printf("No dept with %d was found. \n", deptId);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction!=null) transaction.rollback();
            System.out.printf("Update failed - %s", e.getMessage());
        }
    }
    public static void findDept(Session session, int deptId){
        Transaction transaction = session.beginTransaction();
        try {
            Department dept = session.get(Department.class, deptId);
            if (dept != null) {
                System.out.printf("Department found: %s\n", dept.getName());
            } else {
                System.out.printf("No dept with %d was found. \n", deptId);
            }
        } catch (Exception e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public static void deleteDept(Session session, int deptId){
        Transaction transaction = session.beginTransaction();
        try {
            Department dept = session.get(Department.class, deptId);
            if (dept != null) {
                session.delete(dept);
                transaction.commit();
                System.out.println("Department removed from database successfully.");
            } else {
                System.out.println("No dept found currently in database.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }e.printStackTrace();
        }
    }


}
