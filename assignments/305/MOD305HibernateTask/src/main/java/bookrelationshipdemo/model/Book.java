package bookrelationshipdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity                 // bring table to existence
@Data                   // lombok - set requiredArgsConstructor and getter/setters
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {

    @Id // sets primary key
    // set to auto-generate keys
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // update column name 'id' to "bookId" instead
    @Column(name="bookId")
    private Long id;

    @NonNull
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(mappedBy = "books")
    private List<Publisher> publishers = new ArrayList<>();

    public void addPublisher(Publisher publisher) {
        this.publishers.add(publisher);
//      if current publisher doesn't have our book, then add it
//        ENSURING bi-directional relationship
        if (!publisher.getBooks().contains(this)) {
            publisher.getBooks().add(this);
        }
    }

    public void removePublisher(Publisher publisher) {
//        Remove the publisher from our book object list of publishers
        publishers.remove(publisher);
//        Remove THIS book from the publisher object list of books
        publisher.getBooks().remove(this);      // bi-directional
    }

}
