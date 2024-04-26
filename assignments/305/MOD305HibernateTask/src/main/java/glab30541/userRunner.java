package glab30541;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static glab30541.controller.UserController.namedQueryExample;

public class userRunner {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("usersdb.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        try {
            // Perform CRUD operations
//            System.out.println("TEST");
//              addUser(session);  // Uncomment to add users
//            findUser(session, 2); // Replace '3' with the actual user ID you want to find
//            updateUser(session, 3); // Replace '3' with the actual user ID you want to update
//            deleteUser(session, 4); // Replace '4' with the actual user ID you want to delete
//            findUserHql(session);
//            getRecordById(session);
//            getRecords(session);
//            getMaxSalary(session);
//            getRecordCount(session);
//            getmaxSalaryGroupBy(session);
            namedQueryExample(session);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
