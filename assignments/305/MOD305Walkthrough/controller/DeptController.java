package controller;

import model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeptController {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            addDept(session);
            getDeptById(session,3);
            updateDept(session, 1);
            getDeptById(session,1);
            deleteDept(session, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }

    }


    static void addDept(Session session) {
        Transaction transaction = session.beginTransaction();
        try {
            Department dept1 = new Department("Transportation", "Colorado");
            Department dept2 = new Department("Game and Fish", "California");
            Department dept3 = new Department("Human Resources", "Arizona");

            session.persist(dept1);
            session.persist(dept2);
            session.persist(dept3);

            transaction.commit();
            System.out.println("Inserted new departments into database!");

        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null) transaction.rollback();
            System.out.println("Issue with insertion.");
        }
    }

    static void getDeptById(Session session, int deptId) {
        Transaction transaction = session.beginTransaction();
        try {
            Department dept = session.get(Department.class, deptId);
            if (dept != null){
                int id = dept.getId();
                String deptName = dept.getName();
                String deptState = dept.getState();

//                System.out.printf(" %d | %s | %s", id, deptName, deptState);
                System.out.println( id + " | " + deptName + " | " + deptState);
            }
//          Conclude transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    static void updateDept(Session session, int id) {
        Transaction transaction = session.beginTransaction();
        try {
            Department dept = session.get(Department.class, id);

            if (dept != null) {
//              Cannot update PRIMARY Key (prevent duplicate keys)
                dept.setName("XXXXXXX");
                dept.setState("XXXXXXX");
                System.out.println("Successfully Updated!");
//              ------------------------
//              session.update(dept);  <--- older versions
                session.merge(dept);  // <--- current method in recent versions
//              ------------------------
            }else{
                System.out.println("Dept was not found!");
            }
            transaction.commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    static void deleteDept(Session session, int id){
        Transaction transaction = session.beginTransaction();

        try{
            Department dept = session.get(Department.class, id);
            if (dept != null) {
                session.delete(dept);
                transaction.commit();
                System.out.println("Deleted entry from Database!");
            }else{
                System.out.println("Unable to retrieve entry...");
            }
        }catch(Exception e){
            if(transaction!=null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
