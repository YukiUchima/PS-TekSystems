package Model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TeacherId;
    @NotNull
    private String teacherName;
    private String salary;

    @OneToOne(cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "address_id", referencedColumnName = "AddressId")
    private Address address;

    @ManyToMany(targetEntity = Cohort.class)
    private Set<Cohort> cohort;

    //    public Teacher(String teacherName, String salary, Address address) {
//        this.teacherName = teacherName;
//        this.salary = salary;
//        this.address = address;
//    }
//
    public Teacher(String salary, String teacherName) {
        this.salary = salary;
        this.teacherName = teacherName;
    }

    public Teacher( String salary, String teacherName, Set<Cohort> cohort) {
        this.salary = salary;
        this.teacherName = teacherName;
        this.cohort = cohort;
    }
}