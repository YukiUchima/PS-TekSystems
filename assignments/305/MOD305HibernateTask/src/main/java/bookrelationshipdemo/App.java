package bookrelationshipdemo;

import bookrelationshipdemo.model.Author;
import bookrelationshipdemo.model.Biography;
import bookrelationshipdemo.model.Book;
import bookrelationshipdemo.model.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure("usersdb.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();
        try {
//            //Create Author
            Author author1 = new Author("Stephen King");
            Author author2 = new Author("Asimov");

//            Create Books
            Book book1 = new Book("Cujo");
            Book book2 = new Book("I Robot");
            Book book3 = new Book("IT");

//            Set author object for books
            book1.setAuthor(author1);
            book2.setAuthor(author2);
            book3.setAuthor(author1);

//            Set book to author
            author1.addBook(book1);
            author2.addBook(book2);
            author1.addBook(book3);

//            Create biography and set to author
            String bio1 = "Stephen King's books have been adapted to many films, including IT.";
            Biography bioKing = new Biography(bio1);

            author1.setBiography(bioKing);

//            Create publisher, and set it to the book
            Publisher pub1 = new Publisher("Amazon");
//            Link publisher to the books
            book1.addPublisher(pub1);
            book2.addPublisher(pub1);
            book3.addPublisher(pub1);

//            Persist entities
            session.persist(bioKing);
            session.persist(pub1);
            session.persist(book1);
            session.persist(book2);
            session.persist(book3);
            session.persist(author1);
            session.persist(author2);
            t.commit();
        } catch (Exception e) {
            System.out.printf("Failed main program: %s\n", e.getMessage());
            if (t != null) {
                t.rollback();
            }
        }finally {
            session.close();
            sf.close();
        }
    }
}
