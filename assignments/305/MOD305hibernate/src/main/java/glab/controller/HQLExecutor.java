//package glab.controller;
//
//public class HQLExecutor {
//
//    public static void main(String[] args) {
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        try (Session session = factory.openSession()) {
//            // Using HQL queries
//            listUsers(session);
//            deleteUserByName(session, "Bob");
//        } finally {
//            factory.close();
//        }
//    }
//    public static void listUsers(Session session) {
//        Query<User> query = session.createQuery("FROM User", User.class);
//        for (User user : query.list()) {
//            System.out.println("User: " + user.getFullName());
//        }
//    }
//
//    public static void deleteUserByName(Session session, String fullName) {
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("DELETE FROM User u WHERE u.fullName = :fullName");
//        query.setParameter("fullName", fullName);
//        int result = query.executeUpdate();
//        System.out.println("Users deleted: " + result);
//        transaction.commit();
//    }
//
//}
