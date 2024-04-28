package relationshipsReviewSession.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
//@RequiredArgsConstructor        // required due to @NonNull "String name" declared below
@AllArgsConstructor
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

//  targetEntity - In the resulting relational table in the database,
//  the id's between the author and books will be mapped.
    @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)       // ONE author to MANY books
//    @Singular("addingNewBook")
    @Builder.Default
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public void removeBook(Book book) {
        this.bookList.remove(book);
    }
}
