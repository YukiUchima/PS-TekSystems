package reviewsession0427.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "Book_Store")           // changes the table name
@Data
@Builder
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor     // required with @Builder
public class Store {

    @Id
    @Column(name = "storeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String storeName;

    //    Many To Many: Many Stores sell Many books
    @ManyToMany
    @JoinTable(name = "store_book",
            joinColumns = {@JoinColumn(name = "storeId", referencedColumnName = "storeId")},
            inverseJoinColumns = {@JoinColumn(name = "bookId", referencedColumnName = "bookId")})
//    @JoinTable(name = "storeContainingbooks",
//    joinColumns = @JoinColumn(name="Store_ID"), inverseJoinColumns = @JoinColumn(name = "Book_Id"))
    @Builder.Default
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        if (!book.getStores().contains(this)) {
            book.getStores().add(this);             // checks the
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.getStores().remove(this);
    }
}
