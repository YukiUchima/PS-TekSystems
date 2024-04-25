package glab.controller;

import glab.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserController {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            // Perform CRUD operations
//            System.out.println("TEST");
              addUser(session);  // Uncomment to add users
//            findUser(session, 2); // Replace '3' with the actual user ID you want to find
//            updateUser(session, 3); // Replace '3' with the actual user ID you want to update
//            deleteUser(session, 4); // Replace '4' with the actual user ID you want to delete
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

    public static void addUser(Session session) {
        Transaction transaction = session.beginTransaction();
        try {
            User uOne = new User("Moh Haseeb", "haseeb@gmail.com", "has123", 20, 2000.69, "NYC");
            User uTwo = new User("James Santana", "James@gmail.com", "James123", 25, 2060.69, "Dallas");
            User uThree = new User("AH Shahparan", "Shahparan@gmail.com", "Shahparan123", 30, 3060.69, "Chicago");
            User uFour = new User("Christ", "christ@gmail.com", "147852", 35, 35000.3, "NJ");
            User uFive = new User("Sid", "Sid@gmail.com", "s258", 29, 4000.36, "LA");

            session.persist(uOne);
            session.persist(uTwo);
            session.persist(uThree);
            session.persist(uFour);
            session.persist(uFive);

            transaction.commit();
            System.out.println("Users added successfully");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void findUser(Session session, int userId) {
        Transaction transaction = session.beginTransaction();
        try {
            User user = session.get(User.class, userId);
            if (user != null) {
                System.out.println("User found: " + user.getFullName());
            } else {
                System.out.println("No user found with ID: " + userId);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void updateUser(Session session, int userId) {
        Transaction transaction = session.beginTransaction();
        try {
            User user = session.get(User.class, userId);
            if (user != null) {
                user.setFullName("Updated Name");
                user.setEmail("updated.email@example.com");
                session.update(user);
                transaction.commit();
                System.out.println("User updated successfully");
            } else {
                System.out.println("No user found to update.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void deleteUser(Session session, int userId) {
        Transaction transaction = session.beginTransaction();
        try {
            User user = session.get(User.class, userId);
            if (user != null) {
                session.delete(user);
                transaction.commit();
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("No user found to delete.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }












}