package model;
//<!-- Yuki Uchima          -->
//<!-- Class: 2024-RTT-105  -->
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Student is a POJO, configured as a persistent class that represents (or maps to) a table
 * name 'student' in the database. A Student object contains fields that represent student
 * login credentials and a join table containing a registered student's email and course(s)
 * data. The Student class can be viewed as the owner of the bi-directional relationship.
 * Implement Lombok annotations to eliminate boilerplate code.
 */

@Entity
//@Table(name="student")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)        // prevents infinite recursion loop on collections
public class Student {
    @Id
    @Column(length = 50, unique = true)
    @NonNull
    @ToString.Include
    private String email;
    @Column(length = 50)
    @NonNull
    @ToString.Include
    private String name;
    @Column(length = 50)
    @NonNull
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REMOVE, CascadeType.MERGE,
            CascadeType.PERSIST})
    @JoinTable(name = "student_courses",
            joinColumns = @JoinColumn(name = "student_email"),
            inverseJoinColumns = @JoinColumn(name = "courses_id")
    )
    private Set<Course> courses = new HashSet<>();


//    Helper method
    public boolean addCourse(Course newCourse) {
        if (!this.getCourses().contains(newCourse)){
            this.courses.add(newCourse);
            newCourse.addStudent(this);
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
