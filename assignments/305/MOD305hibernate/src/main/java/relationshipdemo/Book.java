//package relationshipdemo;
//
//
//import javax.persistence.*;
//
//@Entity
//public class Book {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String title;
//
//    @ManyToOne
//    @JoinColumn(name = "author_id") // Foreign key column
//    private Author author;
//
//    public Book() {
//    }
//
//    public Book(String title, Author author) {
//        this.title = title;
//        this.author = author;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Author getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Author author) {
//        // Set bidirectional relationship (recommended)
//        this.author = author;
//        if (author != null) {
//            author.addBook(this); // Add book to author's collection (optional)
//        }
//    }
//
//}
