package reviewsession0427.model;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity         // this creates a table
@Data           // Lombok -> sets the setters/getters and reqArgsConstructor
@Builder        //
@AllArgsConstructor //  required with @Builder in order for Builder to work
@NoArgsConstructor  // represents blank constructor
@RequiredArgsConstructor  //  Lombok annotation that generates constructors for all FINAL and NON-NULL fields.
public class Book {

//    ManyToOne: Many Books - to - One Author
    @Id             // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")    // allows us to rename the column as "bookId"
    private int id;            // Long type for excessive amount of data (millions for example)

    private String title;
    @NonNull
    private int pages;
    @ManyToMany(mappedBy = "books") // This is the name of the collection "books" define within the Store object
    @Builder.Default
    private List<Store> stores = new ArrayList<>();

    public void addStore(Store store) {
        stores.add(store);
        if (!store.getBooks().contains(this)) {
            store.getBooks().add(this);
        }
    }

    public void removeStore(Store store) {
        stores.remove(store);
        store.getBooks().remove(this);
    }








//-------------------------------------- ALREADY DECLARED USING @Data Annotation
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public int getPages() {
//        return pages;
//    }
//
//    public void setPages(int pages) {
//        this.pages = pages;
//    }
}
