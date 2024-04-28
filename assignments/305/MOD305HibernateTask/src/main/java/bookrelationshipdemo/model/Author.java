package bookrelationshipdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity         // instantiates as a table (auto created table)
@Data           // lombok - set requiredargsConstruc and getter/setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Author {

    @Id //set primary key
    // sets to auto generate the key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    @NonNull
    private String name;

    //  AUTHOR - to - BOOK: One Author, to many BOOKS
    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);       // Maintain bidirectional relationship
    }

    //  AUTHOR - to - BIOGRAPHY: One to author, to single biography
    @OneToOne(cascade = CascadeType.ALL)
    //REFERENCED name of column by THIS fkey, set to the name indicated "biography_id"
    @JoinColumn(name = "biography_id", referencedColumnName = "bioId")
    private Biography biography;
}
