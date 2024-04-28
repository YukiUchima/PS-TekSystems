package reviewsession0427.controller;


import org.hibernate.Session;
import reviewsession0427.model.Book;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class BookController {

    public static void getAllBooks(Session session) {
        System.out.println("Getting all books--------------------------------------------------------");
        String hql = "FROM Book WHERE id=2";
        TypedQuery<Book> query = session.createQuery(hql, Book.class);
        System.out.println(query.getResultList());
//        for (Book b : query.getResultList()) {
//            Optional.ofNullable(b).ifPresentOrElse(System.out::println,
//                    () -> System.out.println("Store not found"));
//        }

    }
    public static void getBookById(Session session, int id) {
        String hql = "FROM Book E WHERE E.id = :id";
        TypedQuery<Book> query = session.createQuery(hql, Book.class);
//        TypedQuery<Book> query = session.createNamedQuery("Book.findById", Book.class); // Should have worked...
        query.setParameter("id", id);
        Optional.ofNullable(query.getSingleResult().getStores())
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Book not found"));

        }
    }

