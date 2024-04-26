//package relationshipdemo;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//public class Author {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY);
//    private Long id;
//
//    private String name;
//
//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL) // OneToMany with cascade
//    private List<Book> books;
//
//    public Author(){}
//    public Author(String name, List<Book> books) {
//        this.name = name;
//        this.books = books;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
//
//    public void addBook(Book book) {
//
//    }
//}
