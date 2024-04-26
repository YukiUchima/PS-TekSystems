package glab.controller;

import glab.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;

public class NamedExecutor {


    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        try (Session session = factory.openSession()) {
            // Using named queries
            //   listUsers(session);
//            deleteUserByName(session, "Sid");
//          User user = findById(session, 1); // Assume 1 is a valid ID for demonstration
//          if (user != null) {
//              System.out.println("Found User: " + user.getFullName());
//          } else {
//              System.out.println("No user found with the specified ID.");
//          }
        } finally {
            factory.close();
        }
    }


    public static void listUsers(Session session) {
        TypedQuery<User> query = session.createNamedQuery("User.findAll", User.class);
        for (User user : query.getResultList()) {
            System.out.println("User: " + user.getFullName());
        }
    }


    public static void deleteUserByName(Session session, String fullName) {
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createNamedQuery("User.deleteByName");
            query.setParameter("fullName", fullName);
            int result = query.executeUpdate();
            System.out.println("Users deleted: " + result);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }




    public static User findById(Session session, Integer id) {
        try {
            TypedQuery<User> query = session.createNamedQuery("User.findById", User.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println("No user found with ID: " + id);
            return null;
        }
    }

}
