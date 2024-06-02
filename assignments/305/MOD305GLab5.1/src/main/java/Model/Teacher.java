package Model;

import javax.persistence.*;

@Entity
@Table
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    private String salary;
    private String TeacherName;

    @ManyToOne(targetEntity = Department.class, cascade = {CascadeType.ALL})
    private Department department;
    public Teacher() {

    }

    public Teacher(String salary, String teacherName) {
        this.salary = salary;
        TeacherName = teacherName;
    }

    public Teacher(String salary, String teacherName, Department department) {
        this.salary = salary;
        TeacherName = teacherName;
//        this.department = department;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }
}
