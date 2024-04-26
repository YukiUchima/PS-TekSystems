//package relationshipdemo;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//public class MainRunner {
//
//    public static void main(String[] args) {
//
//
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            // Create author and books
//            Author john = new Author("John Doe");
//            Book book1 = new Book("Book Title 1", john);
//            Book book2 = new Book("Book Title 2", john);
//
//            // Set bidirectional relationship
//            john.addBook(book1);
//            john.addBook(book2);
//            book1.setAuthor(john);
//            book2.setAuthor(john);
//
//            // Save the author object (cascades to books)
//            session.merge(john);
//
//            transaction.commit();
//            System.out.println("Author and Books saved successfully!");
//
//        } catch (Exception e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//            factory.close(); // Close sessionFactory
//        }
//
//
//
//    }
//}
