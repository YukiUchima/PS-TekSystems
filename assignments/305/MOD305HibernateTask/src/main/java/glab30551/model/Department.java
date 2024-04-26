package glab30551.model;

import javax.persistence.*;
import java.io.Serial;
import java.util.List;

@Entity
@Table
public class Department {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    private String deptName;


    public Department() {}

    public Department(String deptName) {
        this.deptName = deptName;
    }

    @OneToMany(targetEntity = Teacher.class, cascade = {CascadeType.ALL})
    private List<Teacher> teacherList;

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}

