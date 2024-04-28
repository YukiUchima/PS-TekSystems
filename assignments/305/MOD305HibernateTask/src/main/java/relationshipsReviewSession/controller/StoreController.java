package relationshipsReviewSession.controller;

import org.hibernate.Session;
import relationshipsReviewSession.model.Store;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class StoreController {
    public static void getAllStores(Session session) {
        String hql = "FROM Store";
        TypedQuery<Store> query = session.createQuery(hql, Store.class);
//        TypedQuery<Book> query = session.createNamedQuery("Book.findById", Book.class); // Should have worked...
        for (Store s : query.getResultList()) {
            Optional.ofNullable(s).ifPresentOrElse(System.out::println,
                            () -> System.out.println("Store not found"));
        }


    }
}
