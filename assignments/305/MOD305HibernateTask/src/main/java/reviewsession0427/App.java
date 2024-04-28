package reviewsession0427;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import reviewsession0427.model.Author;
import reviewsession0427.model.Book;
import reviewsession0427.model.Store;

import java.util.List;

public class App {

    public static void main(String[] args) {
        try (SessionFactory sf = new Configuration().configure("demoDB.cfg.xml").buildSessionFactory();
             Session session = sf.openSession()
        ) {
            initDB(session);
//            getBookById(session, 2);
//            getAllBooks(session);
//            getAllStores(session);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void initDB(Session session) {
        //                Book book1 = new Book("IT"); // Same as below line
        Book book1 = Book.builder().title("IT").pages(100).build();
        Book book2 = Book.builder().title("Cujo").pages(123).build();
        Book book3 = Book.builder().title("I Robot").pages(321).build();

        Author author1 = Author.builder().name("Stephen King").bookList(List.of(book1, book2)).build();
        Author author2 = Author.builder().name("Isaac Asimov").build();

        // The "addingNewBook" used here is defined in '@Singular("addingNewBook")'
        Book book4 = Book.builder().title("Are You Dancing?").build();
        Author author3 = Author.builder().bookList(List.of(book4))
                .name("R. U. Asking").build();


//                author1.setBookList(List.of(book1, book2));     // stephen king
        author2.setBookList(List.of(book3));     // Isaac Asimov
        //                BOOK STORE
        Store BN = Store.builder().storeName("Barnes n Noble").build();
        Store Walmart = Store.builder().storeName("WalMart").build();


        BN.addBook(book1);
        Walmart.addBook(book1);
        Walmart.addBook(book2);
        Walmart.addBook(book3);

        Transaction t = session.beginTransaction();
        try {
            System.out.println("Persisting to database");
//                session.persist(book1);
//                session.persist(book2);
//                session.persist(book3);
            session.persist(author1);
            session.persist(author2);
            session.persist(author3);
            session.persist(BN);
            session.persist(Walmart);
            t.commit();                 // committing will make the changes to database
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
    }
}
