package model;
//<!-- Yuki Uchima          -->
//<!-- Class: 2024-RTT-105  -->
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Course is a POJO, configured as a persistent class that represents (or maps to) a table
 * name 'course' in the database. A Course object contains fields that represent course
 * information and a mapping of 'courses' that indicate an inverse or referencing side
 * of the relationship. Implement Lombok annotations to eliminate boilerplate code.
 */

@Entity
//@Table(name="course")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)       // prevents infinite recursion loop on collections
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private int id;
    @Column(length = 50)
    @NonNull
    @ToString.Include
    private String name;
    @Column(length = 50)
    @NonNull
    @ToString.Include
    private String instructor;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REMOVE,
            CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Student> students = new HashSet<>();

    //    Helper method - not used in provided application, but available to maintain bidirectionality
    public void addStudent(Student newStudent) {
        if (!this.getStudents().contains(newStudent)){
            this.students.add(newStudent);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Course course = (Course) object;
        return Objects.equals(name, course.name) && Objects.equals(instructor, course.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, instructor);
    }
}
