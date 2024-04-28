package bookrelationshipdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Publisher {

    @Id     // set as primary key
    // set to auto generate the keys
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)     // PUBLISHER - to - BOOK: Many publishers print many books
    @JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name = "pub_id"), inverseJoinColumns =
    @JoinColumn(name = "bo_id"))
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        this.books.add(book);
//      if current book doesn't have our publisher, then add it
//        ENSURING bi-directional relationship
        if (!book.getPublishers().contains(this)) {
            book.getPublishers().add(this);
        }
    }

    public void removeBook(Book book) {
//        Remove the book from our publisher or THIS object's list of books
        books.remove(book);
//        Remove THIS publisher from the book object list of publishers
        book.getPublishers().remove(this);      // bidirectional
    }
}
